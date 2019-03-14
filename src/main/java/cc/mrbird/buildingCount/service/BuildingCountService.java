package cc.mrbird.buildingCount.service;

import net.minidev.json.JSONArray;
import org.json.JSONException;

import java.math.BigDecimal;

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
}
