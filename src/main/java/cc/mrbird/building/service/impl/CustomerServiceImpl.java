package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CustomerMapper;
import cc.mrbird.building.domain.Customer;
import cc.mrbird.building.service.CustomerService;
import cc.mrbird.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomerServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-27 15:09
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CustomerServiceImpl extends BaseService<Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll(Customer customer) {
        try {
            List<Customer> list = this.customerMapper.findAll(customer);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
