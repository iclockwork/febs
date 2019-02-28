package cc.mrbird.system.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.common.util.Constant;
import cc.mrbird.system.dao.RestrictionMapper;
import cc.mrbird.system.domain.Restriction;
import cc.mrbird.system.service.RestrictionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * RestrictionServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-28 14:47
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("restrictionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RestrictionServiceImpl extends BaseService<Restriction> implements RestrictionService {
    @Autowired
    private RestrictionMapper restrictionMapper;

    @Override
    public List<Restriction> findAll(Restriction restriction) {
        try {
            Example example = new Example(Restriction.class);
            Example.Criteria criteria = example.createCriteria();
            if (null != restriction.getSerialNo() && StringUtils.isNotBlank(restriction.getSerialNo().toString())) {
                criteria.andCondition("serial_no=", restriction.getSerialNo());
            }
            if (StringUtils.isNotBlank(restriction.getDescChina())) {
                criteria.andCondition("desc_china=", restriction.getDescChina());
            }
            if (StringUtils.isNotBlank(restriction.getKeyword())) {
                criteria.andCondition("keyword=", restriction.getKeyword());
            }
            if (StringUtils.isNotBlank(restriction.getKeywordDesc())) {
                criteria.andCondition("keyword_desc=", restriction.getKeywordDesc());
            }
            criteria.andCondition("delete_state=", Constant.DELETE_FLAG_NO);
            example.setOrderByClause("keyword asc,serial_no asc");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
