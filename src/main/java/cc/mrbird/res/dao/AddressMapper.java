package cc.mrbird.res.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.res.domain.Address;
import cc.mrbird.res.domain.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper extends MyMapper<Address> {
    List<Address> findAll(@Param("standName") String standName);
}