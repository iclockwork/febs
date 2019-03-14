package cc.mrbird.res.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.res.domain.Address;

import java.util.List;

public interface AddressMapper extends MyMapper<Address> {
    List<Address> findAll(Address address);
}