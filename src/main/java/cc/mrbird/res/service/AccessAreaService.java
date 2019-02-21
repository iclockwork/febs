package cc.mrbird.res.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.res.domain.AccessArea;

import java.util.List;

/**
 * AccessAreaService
 *
 * @author: fengwang
 * @date: 2019-02-21 16:19
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface AccessAreaService extends IService<AccessArea> {
    List<AccessArea> findAll(AccessArea accessArea);
}
