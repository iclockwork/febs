package cc.mrbird.building.service;

import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * BuildingCustomerRpService
 *
 * @author: fengwang
 * @date: 2019-03-06 16:49
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface BuildingCustomerRpService extends IService<BuildingCustomerRp> {
    List<BuildingCustomerRp> findAll(BuildingCustomerRp buildingCustomerRp);
}
