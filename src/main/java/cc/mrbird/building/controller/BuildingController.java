package cc.mrbird.building.controller;

import cc.mrbird.building.domain.Building;
import cc.mrbird.building.service.BuildingService;
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
 * BuildingController
 *
 * @author: fengwang
 * @date: 2019-02-20 15:47
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class BuildingController extends BaseController {
    @Autowired
    private BuildingService buildingService;

    @Log("获取楼宇信息")
    @RequestMapping("building")
    @RequiresPermissions("building:list")
    public String index() {
        return "building/building/index";
    }

    @RequestMapping("building/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Building building) {
        return super.selectByPageNumSize(request, () -> this.buildingService.findAll(workingCondition(building)));
    }

    @RequestMapping("building/excel")
    @ResponseBody
    public ResponseBo excel(Building building) {
        try {
            List<Building> list = this.buildingService.findAll(workingCondition(building));
            return FileUtils.createExcelByPOIKit("楼宇表", list, Building.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("building/csv")
    @ResponseBody
    public ResponseBo csv(Building building) {
        try {
            List<Building> list = this.buildingService.findAll(workingCondition(building));
            return FileUtils.createCsv("楼宇表", list, Building.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @RequestMapping("building/getBuilding")
    @ResponseBody
    public ResponseBo get(Long buildingId) {
        try {
            Building building = this.buildingService.findById(buildingId);
            return ResponseBo.ok(building);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取楼宇信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("building/generateBuildingNo")
    @ResponseBody
    public ResponseBo generateBuildingNo(String buildingType) {
        try {
            String buildingNo = this.buildingService.generateBuildingNo(buildingType);
            return ResponseBo.ok(buildingNo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取楼宇编码失败，请联系网站管理员！");
        }
    }

    @Log("新增楼宇")
    @RequiresPermissions("building:add")
    @RequestMapping("building/add")
    @ResponseBody
    public ResponseBo add(Building building) {
        try {
            building.setCreateStaffId(super.getCurrentUser().getStaffId());
            this.buildingService.add(building);
            return ResponseBo.ok("新增楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增楼宇失败，请联系网站管理员！");
        }
    }

    @Log("修改楼宇")
    @RequiresPermissions("building:update")
    @RequestMapping("building/update")
    @ResponseBody
    public ResponseBo update(Building building) {
        try {
            building.setModifyStaffId(super.getCurrentUser().getStaffId());
            this.buildingService.update(building);
            return ResponseBo.ok("修改楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改楼宇失败，请联系网站管理员！");
        }
    }

    @Log("删除楼宇")
    @RequiresPermissions("building:delete")
    @RequestMapping("building/delete")
    @ResponseBody
    public ResponseBo delete(String buildingIds) {
        try {
            Long staffId = super.getCurrentUser().getStaffId();
            this.buildingService.delete(buildingIds, staffId);
            return ResponseBo.ok("删除楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除楼宇失败，请联系网站管理员！");
        }
    }

    private Building workingCondition(Building building) {
        User user = super.getCurrentUser();
        if (StringUtils.isBlank(building.getDsRegionId())) {
            building.setDsRegionId(user.getRegionId());
        }
        if (Constant.STAFF_TYPE_NORMAL.equals(user.getStaffType())) {
            building.setBuildingManagerId(user.getStaffId());
        }

        return building;
    }
}
