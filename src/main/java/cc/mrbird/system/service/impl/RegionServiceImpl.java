package cc.mrbird.system.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.system.dao.RegionMapper;
import cc.mrbird.system.domain.Region;
import cc.mrbird.system.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * RegionServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-19 16:02
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("regionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RegionServiceImpl extends BaseService<Region> implements RegionService {
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> findAll(Region region) {
        try {
            List<Region> list = this.regionMapper.findAll(region);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
