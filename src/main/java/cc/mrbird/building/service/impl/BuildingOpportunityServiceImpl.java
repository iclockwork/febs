package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BuildingOpportunityMapper;
import cc.mrbird.building.domain.BuildingOpportunity;
import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.building.service.BuildingOpportunityService;
import cc.mrbird.defineConstant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /26
 * Features:
 */
@Service
public class BuildingOpportunityServiceImpl implements BuildingOpportunityService {

    @Autowired
    private BuildingOpportunityMapper buildingOpportunityMapper;
    @Override
    public List<BuildingOpportunity> queryBuildingOpportunity(BuildingOpportunity buildingOpportunity) {
        return buildingOpportunityMapper.queryBuildingOpportunity(buildingOpportunity);
    }

    @Override
    public void addBuildingOpportunity(BuildingOpportunity buildingOpportunity) {
        buildingOpportunity.setDeleteFlag(CommonConstant.VALID);
        buildingOpportunity.setCreateDate(new Date());
        buildingOpportunity.setCreateStaffId(123457);
        buildingOpportunity.setRegionId("213456");
        buildingOpportunityMapper.addBuildingOpportunity(buildingOpportunity);
    }

    @Override
    public BuildingOpportunity findById(Long buildingId) {
        return buildingOpportunityMapper.findById(buildingId);
    }

    @Override
    public void updateBuildingOpportunity(BuildingOpportunity buildingOpportunity) {
        buildingOpportunityMapper.updateBuildingOpportunity(buildingOpportunity);
    }

    @Override
    public void deleteBuildingOpportunity(String ids, int deleteFlag) {
        buildingOpportunityMapper.deleteBuildingOpportunity(ids,deleteFlag);
    }
}
