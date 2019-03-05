package cc.mrbird.system.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.system.dao.StaffMapper;
import cc.mrbird.system.domain.Staff;
import cc.mrbird.system.service.StaffService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * StaffServiceImpl
 *
 * @author: fengwang
 * @date: 2019-03-05 11:15
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("staffService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class StaffServiceImpl extends BaseService<Staff> implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> findAll(Staff staff) {
        try {
            if (StringUtils.isNotBlank(staff.getLoginName())) {
                staff.setLoginName(staff.getLoginName().toLowerCase());
            }
            List<Staff> list = this.staffMapper.findAll(staff);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
