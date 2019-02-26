package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface CustomerExpirationMapper extends MyMapper<CustomerExpiration> {
    List<CustomerExpiration> queryCustomerExpiration(CustomerExpiration customerExpiration);

    void addCustomerExpiration(CustomerExpiration customerExpiration);

    CustomerExpiration findById(Long customerExpirationId);

    void updateCustomerExpiration(CustomerExpiration customerExpiration);

    void deleteCustomerExpiration(String ids, int deleteFlag);
}

