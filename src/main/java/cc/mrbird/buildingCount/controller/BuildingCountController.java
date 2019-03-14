package cc.mrbird.buildingCount.controller;

import cc.mrbird.buildingCount.service.BuildingCountService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.Constant;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ 3/12
 * Features: 页面楼宇数据统计
 */
@Controller
public class BuildingCountController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BuildingCountController.class);
    @Autowired
    private BuildingCountService buildingCountService;

    @Log("统计楼宇")
    @RequestMapping("building/count")
    @ResponseBody
    public ResponseBo countBuilding() {
        try {
            GetUserInfo getUserInfo = new GetUserInfo().invoke();
            String regionId = getUserInfo.getRegionId();
            Long createStaffId = getUserInfo.getCreateStaffId();
            String buildings =this.buildingCountService.countBuilding(regionId,createStaffId);
            return ResponseBo.ok(buildings);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("统计楼宇查询失败，请联系网站管理员！");
        }
    }

    @Log("统计客户")
    @RequestMapping("customer/count")
    @ResponseBody
    public ResponseBo countCustomer() {
        try {
            GetUserInfo getUserInfo = new GetUserInfo().invoke();
            String regionId = getUserInfo.getRegionId();
            Long createStaffId = getUserInfo.getCreateStaffId();
            String customers =this.buildingCountService.countCustomer(regionId,createStaffId);
            return ResponseBo.ok(customers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("统计客户查询失败，请联系网站管理员！");
        }
    }

    @Log("统计客户业务量")
    @RequestMapping("customerBusiness/count")
    @ResponseBody
    public ResponseBo countCustomerBusiness() {
        try {
            GetUserInfo getUserInfo = new GetUserInfo().invoke();
            String regionId = getUserInfo.getRegionId();
            Long createStaffId = getUserInfo.getCreateStaffId();
            String countCustomerBusiness =this.buildingCountService.countCustomerBusiness(regionId,createStaffId);
            return ResponseBo.ok(countCustomerBusiness);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("统计客户业务查询失败，请联系网站管理员！");
        }
    }


    @Log("统计费用收入")
    @RequestMapping("customerFee/count")
    @ResponseBody
    public ResponseBo countCustomerFee() {
        try {
            GetUserInfo getUserInfo = new GetUserInfo().invoke();
            String regionId = getUserInfo.getRegionId();
            Long createStaffId = getUserInfo.getCreateStaffId();
            BigDecimal countCustomerFee =this.buildingCountService.countCustomerFee(regionId,createStaffId);
            if (countCustomerFee == null){
               return ResponseBo.ok("0");
            }
            BigDecimal customerFee = countCustomerFee.divide(new BigDecimal("10000"));
            return ResponseBo.ok(customerFee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("统计客户业务查询失败，请联系网站管理员！");
        }
    }

    @Log("统计客户各业务量")
    @RequestMapping("business/count")
    @ResponseBody
    public ResponseBo countBusiness() {
        try {
            GetUserInfo getUserInfo = new GetUserInfo().invoke();
            String regionId = getUserInfo.getRegionId();
            Long createStaffId = getUserInfo.getCreateStaffId();
            JSONObject countBusiness =this.buildingCountService.queryBusiness(regionId,createStaffId);
            return ResponseBo.ok(countBusiness);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("统计客户各业务量查询失败，请联系网站管理员！");
        }
    }

    @Log("各楼宇客户业务统计")
    @RequestMapping("buildingBusiness/count")
    @ResponseBody
    public ResponseBo countBuildingBusiness() {
        try {
            GetUserInfo getUserInfo = new GetUserInfo().invoke();
            String regionId = getUserInfo.getRegionId();
            Long createStaffId = getUserInfo.getCreateStaffId();
            JSONArray countBuildingBusiness = this.buildingCountService.countBuildingBusiness(regionId, createStaffId);
            logger.info("objects is;" + countBuildingBusiness);
            return ResponseBo.ok(countBuildingBusiness);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("各楼宇客户业务统计查询失败，请联系网站管理员！");
        }
    }

    private class GetUserInfo {
        private String regionId;
        private Long createStaffId;

        public String getRegionId() {
            return regionId;
        }

        public Long getCreateStaffId() {
            return createStaffId;
        }

        public GetUserInfo invoke() {
            regionId = BuildingCountController.super.getCurrentUser().getRegionId();
            createStaffId = null;
            if (!StringUtils.equalsIgnoreCase(regionId, Constant.PROVINCE_FLAG_YES)){
                createStaffId = BuildingCountController.super.getCurrentUser().getStaffId();
            }
            return this;
        }
    }
}
