package cc.mrbird.building.dao;

import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface BuildingCustomerRpMapper extends MyMapper<BuildingCustomerRp> {
    List<BuildingCustomerRp> findAll(BuildingCustomerRp buildingCustomerRp);
}