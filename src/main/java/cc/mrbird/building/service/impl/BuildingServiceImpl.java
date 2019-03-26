package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BuildingMapper;
import cc.mrbird.building.domain.Building;
import cc.mrbird.building.service.BuildingService;
import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.common.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * BuildingServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-20 15:44
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("buildingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BuildingServiceImpl extends BaseService<Building> implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> findAll(Building building) {
        try {
            return this.buildingMapper.findAll(building);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Building findById(Long buildingId) {
        return buildingMapper.findById(buildingId);
    }

    @Override
    public String generateBuildingNo(String buildingType) {
        //根据楼宇类型生成序号
        String seq = buildingMapper.getBuildingNo(buildingType);
        //地市名称英文首字母+楼宇所属区域类型缩写+四位序列号，如NJSC0001
        return buildingType + seq;
    }

    @Override
    @Transactional
    public void add(Building building) {
        building.setBuildingId(this.getSequence(Building.SEQ));
        building.setDeleteFlag(Integer.valueOf(Constant.DELETE_FLAG_NO));
        building.setCreateDate(new Date());
        this.save(building);
    }

    @Override
    @Transactional
    public void update(Building building) {
        building.setModifyDate(new Date());
        this.updateNotNull(building);
    }

    @Override
    @Transactional
    public void delete(String buildingIds, Long staffId) {
        List<String> list = Arrays.asList(buildingIds.split(","));
        list.forEach(buildingId -> {
            Building building = findById(Long.valueOf(buildingId));
            building.setDeleteFlag(Integer.valueOf(Constant.DELETE_FLAG_YES));
            building.setModifyStaffId(staffId);
            building.setModifyDate(new Date());
            this.updateNotNull(building);
        });
    }
}
