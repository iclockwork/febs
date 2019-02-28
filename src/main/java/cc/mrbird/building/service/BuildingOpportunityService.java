package cc.mrbird.building.service;

import cc.mrbird.building.domain.BuildingOpportunity;
import cc.mrbird.building.domain.CustomerExpiration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
public interface BuildingOpportunityService {
    List<BuildingOpportunity> queryBuildingOpportunity(BuildingOpportunity buildingOpportunity);

    void addBuildingOpportunity(BuildingOpportunity buildingOpportunity);

    BuildingOpportunity findById(Long customerExpirationId);

    void updateBuildingOpportunity(CustomerExpiration customerExpiration);

    void deleteBuildingOpportunity(String ids, int deleteFlag);
}
