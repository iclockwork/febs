package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CustomerExpirationMapper;
import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.building.service.CustomerExpirationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
@Service("customerExpirationService")
public class CustomerExpirationServiceImpl implements CustomerExpirationService {
    @Autowired
    private CustomerExpirationMapper customerExpirationMapper;

    @Override
    public List<CustomerExpiration> queryCustomerExpiration(CustomerExpiration customerExpiration) {
        return customerExpirationMapper.queryCustomerExpiration(customerExpiration);
    }

    @Override
    public void addCustomerExpiration(CustomerExpiration customerExpiration) {
        customerExpiration.setBuildingId(12345677);
        customerExpiration.setDeleteFlag((short) 0);
        customerExpiration.setCreateDate(new Date());
        customerExpirationMapper.addCustomerExpiration(customerExpiration);
    }

    @Override
    public CustomerExpiration findById(Long customerExpirationId) {
        return customerExpirationMapper.findById(customerExpirationId);
    }

    @Override
    public void updateCustomerExpiration(CustomerExpiration customerExpiration) {
        customerExpirationMapper.updateCustomerExpiration(customerExpiration);
    }

    @Override
    public void deleteCustomerExpiration(String ids, int deleteFlag) {
        customerExpirationMapper.deleteCustomerExpiration(ids,deleteFlag);
    }
}
