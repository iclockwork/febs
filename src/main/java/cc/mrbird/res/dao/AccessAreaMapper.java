package cc.mrbird.res.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.res.domain.AccessArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccessAreaMapper extends MyMapper<AccessArea> {
    List<AccessArea> findAll(@Param("accessAreaName") String accessAreaName);
}