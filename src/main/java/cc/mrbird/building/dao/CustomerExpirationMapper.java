package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface CustomerExpirationMapper extends MyMapper<CustomerExpiration> {
    List<CustomerExpiration> queryCustomerExpiration(CustomerExpiration customerExpiration);
}

