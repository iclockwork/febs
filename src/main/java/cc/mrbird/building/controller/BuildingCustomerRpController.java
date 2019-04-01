package cc.mrbird.building.controller;

import cc.mrbird.building.domain.BuildingCustomerRp;
import cc.mrbird.building.service.BuildingCustomerRpService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.exception.BusinessException;
import cc.mrbird.common.util.Constant;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        return super.selectByPageNumSize(request, () -> this.buildingCustomerRpService.findAll(workingCondition(buildingCustomerRp)));
    }

    @RequestMapping("buildingCustomerRp/excel")
    @ResponseBody
    public ResponseBo excel(BuildingCustomerRp buildingCustomerRp) {
        try {
            List<BuildingCustomerRp> list = this.buildingCustomerRpService.findAll(workingCondition(buildingCustomerRp));
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
            List<BuildingCustomerRp> list = this.buildingCustomerRpService.findAll(workingCondition(buildingCustomerRp));
            return FileUtils.createCsv("楼宇客户表", list, BuildingCustomerRp.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @Log("新增楼宇客户关系")
    @RequiresPermissions("buildingCustomerRp:add")
    @RequestMapping("buildingCustomerRp/add")
    @ResponseBody
    public ResponseBo add(@RequestBody BuildingCustomerRp[] buildingCustomerRps) {
        try {
            this.buildingCustomerRpService.add(buildingCustomerRps, super.getCurrentUser().getStaffId());
            return ResponseBo.ok("新增楼宇客户关系成功！");
        } catch (BusinessException e) {
            return ResponseBo.error(e.getErrorMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增楼宇客户关系失败，请联系网站管理员！");
        }
    }

    @Log("删除楼宇客户关系")
    @RequiresPermissions("buildingCustomerRp:delete")
    @RequestMapping("buildingCustomerRp/delete")
    @ResponseBody
    public ResponseBo delete(String buildingCustomerRpIds) {
        try {
            Long staffId = super.getCurrentUser().getStaffId();
            this.buildingCustomerRpService.delete(buildingCustomerRpIds, staffId);
            return ResponseBo.ok("删除楼宇客户关系成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除楼宇客户关系失败，请联系网站管理员！");
        }
    }

    private BuildingCustomerRp workingCondition(BuildingCustomerRp buildingCustomerRp) {
        User currentUser = super.getCurrentUser();
        if (StringUtils.isBlank(buildingCustomerRp.getDsRegionId())) {
            buildingCustomerRp.setDsRegionId(currentUser.getRegionId());
        }
        if (Constant.STAFF_TYPE_NORMAL.equals(currentUser.getStaffType())) {
            buildingCustomerRp.setBuildingManagerId(currentUser.getStaffId());
        }

        return buildingCustomerRp;
    }
}
