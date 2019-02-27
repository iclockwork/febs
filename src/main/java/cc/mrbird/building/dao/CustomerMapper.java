package cc.mrbird.building.dao;

import cc.mrbird.building.domain.Building;
import cc.mrbird.building.domain.Customer;
import cc.mrbird.common.config.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper extends MyMapper<Customer> {
    List<Customer> findAll(@Param("customerName") String customerName);
}