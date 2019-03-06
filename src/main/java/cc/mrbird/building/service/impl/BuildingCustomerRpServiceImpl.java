package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BuildingCustomerRpMapper;
import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.building.service.BuildingCustomerRpService;
import cc.mrbird.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * BuildingCustomerRpServiceImpl
 *
 * @author: fengwang
 * @date: 2019-03-06 16:50
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("buildingCustomerRpService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BuildingCustomerRpServiceImpl extends BaseService<BuildingCustomerRp> implements BuildingCustomerRpService {
    @Autowired
    private BuildingCustomerRpMapper buildingCustomerRpMapper;

    @Override
    public List<BuildingCustomerRp> findAll(BuildingCustomerRp buildingCustomerRp) {
        try {
            List<BuildingCustomerRp> list = this.buildingCustomerRpMapper.findAll(buildingCustomerRp);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
