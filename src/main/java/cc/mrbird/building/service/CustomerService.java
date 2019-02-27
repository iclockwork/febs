package cc.mrbird.building.service;

import cc.mrbird.building.domain.Customer;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * CustomerService
 *
 * @author: fengwang
 * @date: 2019-02-27 15:07
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface CustomerService extends IService<Customer> {
    List<Customer> findAll(Customer customer);
}
