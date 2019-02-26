package cc.mrbird.building.service;

import cc.mrbird.building.domain.CustomerExpiration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ 2/22
 * Features:
 */
public interface CustomerExpirationService {
    List<CustomerExpiration> queryCustomerExpiration(CustomerExpiration customerExpiration);

    void addCustomerExpiration(CustomerExpiration customerExpiration);

    CustomerExpiration findById(Long customerExpirationId);

    void updateCustomerExpiration(CustomerExpiration customerExpiration);

    void deleteCustomerExpiration(String ids, int deleteFlag);
}
