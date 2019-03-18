package cc.mrbird.res.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.res.domain.AccessArea;

import java.util.List;

public interface AccessAreaMapper extends MyMapper<AccessArea> {
    List<AccessArea> findAll(AccessArea accessArea);
}