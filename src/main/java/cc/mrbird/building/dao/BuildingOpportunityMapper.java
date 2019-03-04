package cc.mrbird.building.dao;

import cc.mrbird.building.domain.BuildingOpportunity;
import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface BuildingOpportunityMapper extends MyMapper<BuildingOpportunity> {
    List<BuildingOpportunity> queryBuildingOpportunity(BuildingOpportunity buildingOpportunity);

    void addBuildingOpportunity(BuildingOpportunity buildingOpportunity);

    BuildingOpportunity findById(Long buildingId);

    void updateBuildingOpportunity(BuildingOpportunity buildingOpportunity);

    void deleteBuildingOpportunity(int[] ids);
}