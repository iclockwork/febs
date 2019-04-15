package cc.mrbird.buildingCount.service;

import cc.mrbird.building.domain.Building;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ 3/12
 * Features:
 */
public interface BuildingCountService {
    String countBuilding(String regionId, Long createStaffId);

    String countCustomer(String regionId, Long createStaffId);

    String countCustomerBusiness(String regionId, Long createStaffId);

    BigDecimal countCustomerFee(String regionId, Long createStaffId);

    JSONArray countBuildingBusiness(String regionId, Long createStaffId) throws JSONException;

    JSONObject queryBusiness(String regionId, Long createStaffId);

    List<Building> queryBuildingList(String regionId, Long createStaffId);
}
