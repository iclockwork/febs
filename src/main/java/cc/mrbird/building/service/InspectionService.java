package cc.mrbird.building.service;

import cc.mrbird.building.domain.Inspection;
import cc.mrbird.common.service.IService;

import java.util.List;

/**
 * InspectionService
 *
 * @author: fengwang
 * @date: 2019-03-25 15:31
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface InspectionService extends IService<Inspection> {
    List<Inspection> findAll(Inspection inspection);
}
