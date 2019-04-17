package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CustomerExpirationMapper;
import cc.mrbird.building.domain.Customer;
import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.building.service.CustomerExpirationService;
import cc.mrbird.common.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
@Service("customerExpirationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CustomerExpirationServiceImpl implements CustomerExpirationService {
    @Autowired
    private CustomerExpirationMapper customerExpirationMapper;

    @Override
    public List<CustomerExpiration> queryCustomerExpiration(CustomerExpiration customerExpiration) {
        return customerExpirationMapper.queryCustomerExpiration(customerExpiration);
    }

    @Override
    public void addCustomerExpiration(CustomerExpiration customerExpiration) {
        customerExpiration.setDeleteFlag(Short.valueOf(Constant.DELETE_FLAG_NO));
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
    public void deleteCustomerExpiration(String ids) {
        int[] ints = Arrays.stream(ids.split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        customerExpirationMapper.deleteCustomerExpiration(ints);
    }

    @Override
    public List<Customer> findAll(Customer customer) {
        try {
            return this.customerExpirationMapper.findAll(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
