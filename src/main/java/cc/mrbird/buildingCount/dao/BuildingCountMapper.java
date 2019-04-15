package cc.mrbird.buildingCount.dao;


import cc.mrbird.building.domain.Building;

import java.math.BigDecimal;
import java.util.List;

public interface BuildingCountMapper {

    String countBuilding(String regionId, Long createStaffId);

    String countCustomer(String regionId, Long createStaffId);

    String countCustomerBusiness(String regionId, Long createStaffId);

    BigDecimal countCustomerFee(String regionId, Long createStaffId);


    List<Building> queryBuilding(String regionId, Long createStaffId);

    List<Integer> queryCustomerBusiness(String buildingNo);

    List<Integer>  queryBusiness(String regionId, Long createStaffId);

    List<Building> queryBuildingList(String regionId, Long createStaffId);
}