package cc.mrbird.building.dao;

import cc.mrbird.building.domain.Customer;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface CustomerMapper extends MyMapper<Customer> {
    List<Customer> findAll(Customer customer);
}