package cc.mrbird.building.service;

import cc.mrbird.building.domain.BuildingOpportunity;
import cc.mrbird.building.domain.CustomerOpportunity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
public interface CustomerOpportunityService {
    List<CustomerOpportunity> queryCustomerOpportunity(CustomerOpportunity customerOpportunity);

    void addCustomerOpportunity(CustomerOpportunity customerOpportunity);

    CustomerOpportunity findById(Long customerId);

    void updateCustomerOpportunity(CustomerOpportunity customerExpiration);

    void deleteCustomerOpportunity(String ids, int deleteFlag);
}
