package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BuildingCustomerRpMapper;
import cc.mrbird.building.domain.Building;
import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.building.service.BuildingCustomerRpService;
import cc.mrbird.common.exception.BusinessException;
import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.common.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * BuildingCustomerRpServiceImpl
 *
 * @author: fengwang
 * @date: 2019-03-06 16:50
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("buildingCustomerRpService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BuildingCustomerRpServiceImpl extends BaseService<BuildingCustomerRp> implements BuildingCustomerRpService {
    @Autowired
    private BuildingCustomerRpMapper buildingCustomerRpMapper;

    @Override
    public List<BuildingCustomerRp> findAll(BuildingCustomerRp buildingCustomerRp) {
        try {
            List<BuildingCustomerRp> list = this.buildingCustomerRpMapper.findAll(buildingCustomerRp);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public BuildingCustomerRp findById(Long buildingCustomerRpId) {
        return buildingCustomerRpMapper.findById(buildingCustomerRpId);
    }

    @Override
    public void add(BuildingCustomerRp[] buildingCustomerRps, Long staffId) {
        if (null != buildingCustomerRps) {
            for (int i = 0, length = buildingCustomerRps.length; i < length; i++) {
                BuildingCustomerRp buildingCustomerRp = buildingCustomerRps[i];
                Example example = new Example(BuildingCustomerRp.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andCondition("building_no=", buildingCustomerRp.getBuildingNo());
                criteria.andCondition("segm_id=", buildingCustomerRp.getSegmId());
                criteria.andCondition("customer_no=", buildingCustomerRp.getCustomerNo());
                criteria.andCondition("delete_flag=", Constant.DELETE_FLAG_NO);
                List<BuildingCustomerRp> list = this.selectByExample(example);

                //检查是否已经绑定过
                if (null != list && !list.isEmpty()) {
                    StringBuffer sb = new StringBuffer();
                    sb.append("楼宇九级地址").append(buildingCustomerRp.getStandName()).append("与客户").append(buildingCustomerRp.getCustomerName()).append("已经存在关联关系");
                    throw new BusinessException(sb.toString());
                } else {
                    buildingCustomerRp.setBuildingCustomerRpId(this.getSequence(Building.SEQ));
                    buildingCustomerRp.setDeleteFlag(Integer.valueOf(Constant.DELETE_FLAG_NO));
                    buildingCustomerRp.setCreateStaffId(staffId);
                    buildingCustomerRp.setCreateDate(new Date());
                    this.save(buildingCustomerRp);
                }
            }
        }
    }

    @Override
    public void delete(String buildingCustomerRpIds, Long staffId) {
        List<String> list = Arrays.asList(buildingCustomerRpIds.split(","));
        list.forEach(buildingId -> {
            BuildingCustomerRp buildingCustomerRp = findById(Long.valueOf(buildingId));
            buildingCustomerRp.setDeleteFlag(Integer.valueOf(Constant.DELETE_FLAG_YES));
            buildingCustomerRp.setModifyStaffId(staffId);
            buildingCustomerRp.setModifyDate(new Date());
            this.updateNotNull(buildingCustomerRp);
        });
    }
}
