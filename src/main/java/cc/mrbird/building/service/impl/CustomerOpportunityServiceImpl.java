package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CustomerOpportunityMapper;
import cc.mrbird.building.domain.BuildingOpportunity;
import cc.mrbird.building.domain.CustomerOpportunity;
import cc.mrbird.building.service.CustomerOpportunityService;
import cc.mrbird.defineConstant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /26
 * Features:
 */
@Service
public class CustomerOpportunityServiceImpl implements CustomerOpportunityService {
    @Autowired
    private CustomerOpportunityMapper customerOpportunityMapper;
    @Override
    public List<CustomerOpportunity> queryCustomerOpportunity(CustomerOpportunity customerOpportunity) {
        return customerOpportunityMapper.queryCustomerOpportunity(customerOpportunity);
    }

    @Override
    public void addCustomerOpportunity(CustomerOpportunity customerOpportunity) {
        customerOpportunity.setDeleteFlag(CommonConstant.VALID);
        customerOpportunity.setCreateDate(new Date());
        customerOpportunityMapper.addCustomerOpportunity(customerOpportunity);
    }

    @Override
    public BuildingOpportunity findById(Long customerId) {
        return customerOpportunityMapper.findById(customerId);
    }

    @Override
    public void updateCustomerOpportunity(CustomerOpportunity customerExpiration) {
        customerOpportunityMapper.updateCustomerOpportunity(customerExpiration);
    }

    @Override
    public void deleteCustomerOpportunity(String ids, int deleteFlag) {
        customerOpportunityMapper.deleteCustomerOpportunity(ids,deleteFlag);
    }
}
