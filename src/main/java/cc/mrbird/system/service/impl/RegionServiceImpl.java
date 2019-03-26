package cc.mrbird.system.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.common.util.Constant;
import cc.mrbird.system.dao.RegionMapper;
import cc.mrbird.system.domain.Region;
import cc.mrbird.system.service.RegionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
            return this.regionMapper.findAll(region);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Region> regions(Region region) {
        try {
            Example example = new Example(Region.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(region.getSuperRegionId())) {
                criteria.andCondition("super_region_id=", region.getSuperRegionId());
            }
            if (null != region.getGradeId() && StringUtils.isNotBlank(region.getGradeId().toString())) {
                criteria.andCondition("grade_id=", region.getGradeId());
            }
            criteria.andCondition("res_type_id=", 200);
            criteria.andCondition("region_name not like", "%虚拟%");
            criteria.andCondition("delete_state=", Constant.DELETE_FLAG_NO);
            example.setOrderByClause("region_id asc");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
