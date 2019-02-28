package cc.mrbird.building.service;

import cc.mrbird.building.domain.Building;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * BuildingService
 *
 * @author: fengwang
 * @date: 2019-02-20 15:41
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface BuildingService extends IService<Building> {
    List<Building> findAll(Building building);

    Building findById(Integer buildingId);
}
