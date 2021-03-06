package cc.mrbird.building.controller;


import cc.mrbird.building.domain.BuildingOpportunity;
import cc.mrbird.building.service.BuildingOpportunityService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.Constant;
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
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /18
 * Features:商机楼宇
 */

@Controller
public class BuildingOpportunityController extends BaseController {


    @Autowired
    private BuildingOpportunityService buildingOpportunityService;

    @Log("获取商机楼宇信息")
    @RequestMapping("buildingOpportunity")
    @RequiresPermissions("buildingOpportunity:list")
    public String index() {
        return "building/buildingOpportunity/buildingOpportunity";
    }

    @RequestMapping("buildingOpportunity/list")
    @ResponseBody
    public Map<String, Object> queryBuildingOpportunity(QueryRequest request, BuildingOpportunity buildingOpportunity) {
        return  super.selectByPageNumSize(request, () -> this.buildingOpportunityService.queryBuildingOpportunity(workingCondition(buildingOpportunity)));
    }

    @RequestMapping("buildingOpportunity/excel")
    @ResponseBody
    public ResponseBo exportExcel(BuildingOpportunity buildingOpportunity,QueryRequest request) {
        try {
            List<BuildingOpportunity> list = this.buildingOpportunityService.queryBuildingOpportunity(workingCondition(buildingOpportunity));
            return FileUtils.createExcelByPOIKit("商机楼宇表", list, BuildingOpportunity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("buildingOpportunity/csv")
    @ResponseBody
    public ResponseBo exportCsv(BuildingOpportunity buildingOpportunity,QueryRequest request) {
        try {
            List<BuildingOpportunity> list = this.buildingOpportunityService.queryBuildingOpportunity(workingCondition(buildingOpportunity));
            return FileUtils.createCsv("商机楼宇表", list, BuildingOpportunity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @Log("新增商机楼宇")
    @RequiresPermissions("buildingOpportunity:add")
    @RequestMapping("buildingOpportunity/add")
    @ResponseBody
    public ResponseBo addBuildingOpportunity(BuildingOpportunity buildingOpportunity) {
        try {
            buildingOpportunity.setCreateStaffId(super.getCurrentUser().getStaffId());
            this.buildingOpportunityService.addBuildingOpportunity(buildingOpportunity);
            return ResponseBo.ok("新增商机楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增商机楼宇失败，请联系网站管理员！");
        }
    }

    @RequestMapping("buildingOpportunity/getBuildingOpportunity")
    @ResponseBody
    public ResponseBo getBuildingOpportunity(Long buildingId) {
        try {
            BuildingOpportunity buildingOpportunity  = this.buildingOpportunityService.findById(buildingId);
            return ResponseBo.ok(buildingOpportunity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取商机楼宇信息失败，请联系网站管理员！");
        }
    }


    @Log("修改商机楼宇")
    @RequiresPermissions("buildingOpportunity:update")
    @RequestMapping("buildingOpportunity/update")
    @ResponseBody
    public ResponseBo updateBuildingOpportunity(BuildingOpportunity buildingOpportunity) {
        try {
            this.buildingOpportunityService.updateBuildingOpportunity(buildingOpportunity);
            return ResponseBo.ok("修改商机楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改商机楼宇失败，请联系网站管理员！");
        }
    }

    @Log("删除商机楼宇")
    @RequiresPermissions("buildingOpportunity:delete")
    @RequestMapping("buildingOpportunity/delete")
    @ResponseBody
    public ResponseBo deleteBuildingOpportunity(String ids) {
        try {
            this.buildingOpportunityService.deleteBuildingOpportunity(ids);
            return ResponseBo.ok("删除商机楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除商机楼宇失败，请联系网站管理员！");
        }
    }


    private BuildingOpportunity workingCondition(BuildingOpportunity buildingOpportunity) {
        User currentUser = super.getCurrentUser();
        if (StringUtils.isBlank(buildingOpportunity.getDsRegionId())) {
            buildingOpportunity.setDsRegionId(currentUser.getRegionId());
        }
        if (Constant.STAFF_TYPE_NORMAL.equals(currentUser.getStaffType())) {
            buildingOpportunity.setCreateStaffId(currentUser.getStaffId());
        }

        return buildingOpportunity;
    }
}
