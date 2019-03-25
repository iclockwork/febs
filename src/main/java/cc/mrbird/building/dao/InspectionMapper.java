package cc.mrbird.building.dao;

import cc.mrbird.building.domain.Inspection;
import cc.mrbird.common.config.MyMapper;

import java.util.List;

public interface InspectionMapper extends MyMapper<Inspection> {
    List<Inspection> findAll(Inspection inspection);
}