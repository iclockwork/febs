package cc.mrbird.system.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.system.domain.Region;

import java.util.List;

/**
 * RegionService
 *
 * @author: fengwang
 * @date: 2019-02-19 15:59
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface RegionService extends IService<Region> {
    List<Region> findAll(Region region);

    List<Region> regions(Region region);
}
