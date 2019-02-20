package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BuildingMapper;
import cc.mrbird.building.domain.Building;
import cc.mrbird.building.service.BuildingService;
import cc.mrbird.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * BuildingServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-20 15:44
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("buildingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BuildingServiceImpl extends BaseService<Building> implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> findAll(Building building) {
        try {
            List<Building> list = this.buildingMapper.findAll(building.getBuildingName());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
