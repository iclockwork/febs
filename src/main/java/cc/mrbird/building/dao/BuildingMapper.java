package cc.mrbird.building.dao;

import cc.mrbird.building.domain.Building;
import cc.mrbird.common.config.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingMapper extends MyMapper<Building> {
    List<Building> findAll(Building building);

    Building findById(Integer buildingId);
}