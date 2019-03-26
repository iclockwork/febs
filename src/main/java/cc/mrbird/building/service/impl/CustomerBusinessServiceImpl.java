package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CustomerBusinessMapper;
import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.building.service.CustomerBusinessService;
import cc.mrbird.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomerBusinessServiceImpl
 *
 * @author: fengwang
 * @date: 2019-03-26 16:28
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("customerBusinessService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CustomerBusinessServiceImpl extends BaseService<CustomerBusiness> implements CustomerBusinessService {
    @Autowired
    private CustomerBusinessMapper customerBusinessMapper;

    @Override
    public List<CustomerBusiness> findAll(CustomerBusiness customerBusiness) {
        try {
            return this.customerBusinessMapper.findAll(customerBusiness);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
