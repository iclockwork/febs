package cc.mrbird.building.controller;

import cc.mrbird.building.domain.Building;
import cc.mrbird.building.service.BuildingService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
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
        return super.selectByPageNumSize(request, () -> this.buildingService.findAll(building));
    }

    @RequestMapping("building/excel")
    @ResponseBody
    public ResponseBo excel(Building building) {
        try {
            List<Building> list = this.buildingService.findAll(building);
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
            List<Building> list = this.buildingService.findAll(building);
            return FileUtils.createCsv("楼宇表", list, Building.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }


    @RequestMapping("building/getBuilding")
    @ResponseBody
    public ResponseBo getBuildingOpportunity(Integer buildingId) {
        try {
            Building building  = this.buildingService.findById(buildingId);
            return ResponseBo.ok(building);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取楼宇信息失败，请联系网站管理员！");
        }
    }
}
