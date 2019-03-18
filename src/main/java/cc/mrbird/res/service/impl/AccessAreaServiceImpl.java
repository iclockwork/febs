package cc.mrbird.res.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.res.dao.AccessAreaMapper;
import cc.mrbird.res.domain.AccessArea;
import cc.mrbird.res.service.AccessAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * AccessAreaServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-21 16:20
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("accessAreaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AccessAreaServiceImpl extends BaseService<AccessArea> implements AccessAreaService {
    @Autowired
    private AccessAreaMapper accessAreaMapper;

    @Override
    public List<AccessArea> findAll(AccessArea accessArea) {
        try {
            List<AccessArea> list = this.accessAreaMapper.findAll(accessArea);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
