package cc.mrbird.building.controller;

import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.building.service.BuildingCustomerRpService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * BuildingCustomerRpController
 *
 * @author: fengwang
 * @date: 2019-03-06 16:52
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class BuildingCustomerRpController extends BaseController {
    @Autowired
    private BuildingCustomerRpService buildingCustomerRpService;

    @Log("获取楼宇客户信息")
    @RequestMapping("buildingCustomerRp")
    @RequiresPermissions("buildingCustomerRp:list")
    public String index() {
        return "building/buildingCustomerRp/index";
    }

    @RequestMapping("buildingCustomerRp/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, BuildingCustomerRp buildingCustomerRp) {
        User user = super.getCurrentUser();
        if (StringUtils.isBlank(buildingCustomerRp.getDsRegionId())) {
            buildingCustomerRp.setDsRegionId(user.getRegionId());
        }
        return super.selectByPageNumSize(request, () -> this.buildingCustomerRpService.findAll(buildingCustomerRp));
    }

    @RequestMapping("buildingCustomerRp/excel")
    @ResponseBody
    public ResponseBo excel(BuildingCustomerRp buildingCustomerRp) {
        try {
            List<BuildingCustomerRp> list = this.buildingCustomerRpService.findAll(buildingCustomerRp);
            return FileUtils.createExcelByPOIKit("楼宇客户表", list, BuildingCustomerRp.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("buildingCustomerRp/csv")
    @ResponseBody
    public ResponseBo csv(BuildingCustomerRp buildingCustomerRp) {
        try {
            List<BuildingCustomerRp> list = this.buildingCustomerRpService.findAll(buildingCustomerRp);
            return FileUtils.createCsv("楼宇客户表", list, BuildingCustomerRp.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
