package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CustomerOpportunity;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface CustomerOpportunityMapper extends MyMapper<CustomerOpportunity> {
    List<CustomerOpportunity> queryCustomerOpportunity(CustomerOpportunity customerOpportunity);

    void addCustomerOpportunity(CustomerOpportunity customerOpportunity);

    CustomerOpportunity findById(Long customerId);

    void updateCustomerOpportunity(CustomerOpportunity customerExpiration);

    void deleteCustomerOpportunity(int[] ids);
}