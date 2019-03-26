package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface CustomerBusinessMapper extends MyMapper<CustomerBusiness> {
    List<CustomerBusiness> findAll(CustomerBusiness customerBusiness);

    Long findTotal(CustomerBusiness customerBusiness);
}