package cc.mrbird.system.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.system.domain.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionMapper extends MyMapper<Region> {
    List<Region> findAll(@Param("regionName") String regionName);
}