package cc.mrbird.system.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.system.domain.Restriction;

import java.util.List;

/**
 * RestrictionService
 *
 * @author: fengwang
 * @date: 2019-02-28 14:45
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface RestrictionService extends IService<Restriction> {
    List<Restriction> findAll(Restriction restriction);
}
