package cc.mrbird.buildingCount.service.impl;

import cc.mrbird.building.domain.Building;
import cc.mrbird.buildingCount.dao.BuildingCountMapper;
import cc.mrbird.buildingCount.service.BuildingCountService;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BuildingCountServiceImpl implements BuildingCountService {

    @Autowired
    private BuildingCountMapper buildingCountMapper;

    @Override
    public String countBuilding(String regionId, Long createStaffId) {

        return buildingCountMapper.countBuilding(regionId, createStaffId);
    }

    @Override
    public String countCustomer(String regionId, Long createStaffId) {
        return buildingCountMapper.countCustomer(regionId, createStaffId);
    }

    @Override
    public String countCustomerBusiness(String regionId, Long createStaffId) {
        return buildingCountMapper.countCustomerBusiness(regionId, createStaffId);
    }

    @Override
    public BigDecimal countCustomerFee(String regionId, Long createStaffId) {
        return buildingCountMapper.countCustomerFee(regionId, createStaffId);
    }

    @Override
    public JSONArray countBuildingBusiness(String regionId, Long createStaffId){
        JSONArray countBusiness = new JSONArray();
        List<Building> buildings = buildingCountMapper.queryBuilding(regionId, createStaffId);
        if (buildings.isEmpty()) {
            return countBusiness;
        }
        for (Building building : buildings) {

            JSONObject data = new JSONObject();
            String buildingName = building.getBuildingName();
            data.put("buildingName", buildingName);
            List<Integer> businessTypes = buildingCountMapper.queryCustomerBusiness(building.getBuildingNo());
            if (businessTypes.isEmpty()) {
                continue;
            }
            setData(data, businessTypes);
            countBusiness.add(data);
        }
        return countBusiness;
    }

    @Override
    public JSONObject queryBusiness(String regionId, Long createStaffId) {
        JSONObject data = new JSONObject();
        List<Integer> businessTypes = buildingCountMapper.queryBusiness(regionId, createStaffId);
        if (businessTypes.isEmpty()) {
            return  data;
        }
        setData(data, businessTypes);
        return data;
    }

    @Override
    public List<Building> queryBuildingList(String regionId, Long createStaffId) {
        return buildingCountMapper.queryBuildingList(regionId,createStaffId);
    }

    private void setData(JSONObject data, List<Integer> businessTypes) {
        int zx = 0, kd = 0, gh = 0, y = 0, yw = 0, dl = 0;
        List<Integer> business = new ArrayList<>();
        for (Integer businessType : businessTypes) {
            switch (businessType) {
                case 1:
                    zx++;
                    break;
                case 2:
                    kd++;
                    break;
                case 3:
                    gh++;
                    break;
                case 4:
                    y++;
                    break;
                case 5:
                    yw++;
                    break;
                case 6:
                    dl++;
                    break;
                default:
                    break;
            }
        }
        business.add(zx);
        business.add(kd);
        business.add(gh);
        business.add(y);
        business.add(yw);
        business.add(dl);
        data.put("business",business);
    }

}
