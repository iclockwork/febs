package cc.mrbird.building.dao;

import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.common.config.MyMapper;

import java.math.BigDecimal;
import java.util.List;

public interface BuildingCustomerRpMapper extends MyMapper<BuildingCustomerRp> {
    List<BuildingCustomerRp> findAll(BuildingCustomerRp buildingCustomerRp);

    BuildingCustomerRp findById(Long buildingCustomerRpId);

    Long findCustomerTotal(BuildingCustomerRp buildingCustomerRp);

    Long findBuildingTotal(BuildingCustomerRp buildingCustomerRp);

    Long findCustomerBusinessTotal(BuildingCustomerRp buildingCustomerRp);

    BigDecimal findCustomerBusinessMonthFeeTotal(BuildingCustomerRp buildingCustomerRp);
}