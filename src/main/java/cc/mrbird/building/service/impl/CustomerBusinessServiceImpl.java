package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CustomerBusinessMapper;
import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.building.service.CustomerBusinessService;
import cc.mrbird.common.service.impl.BaseService;
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

    @Override
    public List<CustomerBusiness> findAllByBuilding(String buildingNo) {
        try {
            return this.customerBusinessMapper.findAllByBuilding(buildingNo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<CustomerBusiness> countByBuilding(String buildingNo) {
        try {
            return this.customerBusinessMapper.countByBuilding(buildingNo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<CustomerBusiness> sumMonthFeeByBuilding(String buildingNo) {
        try {
            return this.customerBusinessMapper.sumMonthFeeByBuilding(buildingNo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public CustomerBusiness findById(Long customerBusinessId) {
        return customerBusinessMapper.findById(customerBusinessId);
    }

    @Override
    public void add(CustomerBusiness customerBusiness) {
        customerBusiness.setCustomerBusinessId(this.getSequence(CustomerBusiness.SEQ));
        customerBusiness.setDeleteFlag(Integer.valueOf(Constant.DELETE_FLAG_NO));
        customerBusiness.setCreateDate(new Date());
        this.save(customerBusiness);
    }

    @Override
    public void update(CustomerBusiness customerBusiness) {
        customerBusiness.setModifyDate(new Date());
        this.updateNotNull(customerBusiness);
    }

    @Override
    public void delete(String customerBusinessIds, Long staffId) {
        List<String> list = Arrays.asList(customerBusinessIds.split(","));
        list.forEach(customerBusinessId -> {
            CustomerBusiness customerBusiness = findById(Long.valueOf(customerBusinessId));
            customerBusiness.setDeleteFlag(Integer.valueOf(Constant.DELETE_FLAG_YES));
            customerBusiness.setModifyStaffId(staffId);
            customerBusiness.setModifyDate(new Date());
            this.updateNotNull(customerBusiness);
        });
    }
}
