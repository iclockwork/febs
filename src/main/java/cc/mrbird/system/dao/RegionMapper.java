package cc.mrbird.system.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.system.domain.Region;

import java.util.List;

public interface RegionMapper extends MyMapper<Region> {
    List<Region> findAll(Region region);
}