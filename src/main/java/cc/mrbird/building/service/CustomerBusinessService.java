package cc.mrbird.building.service;

import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * CustomerBusinessService
 *
 * @author: fengwang
 * @date: 2019-03-26 16:26
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface CustomerBusinessService extends IService<CustomerBusiness> {
    List<CustomerBusiness> findAll(CustomerBusiness customerBusiness);
}
