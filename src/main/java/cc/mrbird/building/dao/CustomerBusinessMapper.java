package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.common.config.MyMapper;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerBusinessMapper extends MyMapper<CustomerBusiness> {
    List<CustomerBusiness> findAll(CustomerBusiness customerBusiness);

    CustomerBusiness findById(Long customerBusinessId);

    Long findTotal(CustomerBusiness customerBusiness);

    BigDecimal monthFeeTotal(CustomerBusiness customerBusiness);
}