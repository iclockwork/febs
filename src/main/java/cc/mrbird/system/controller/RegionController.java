package cc.mrbird.system.controller;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.Region;
import cc.mrbird.system.service.RegionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * RegionController
 *
 * @author: fengwang
 * @date: 2019-02-19 16:26
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class RegionController extends BaseController {
    @Autowired
    private RegionService regionService;

    @Log("获取区域信息")
    @RequestMapping("region")
    @RequiresPermissions("region:list")
    public String index() {
        return "system/region/index";
    }

    @RequestMapping("region/list")
    @ResponseBody
    public Map<String, Object> regionList(QueryRequest request, Region region) {
        return super.selectByPageNumSize(request, () -> this.regionService.findAll(region));
    }

    @RequestMapping("region/excel")
    @ResponseBody
    public ResponseBo regionExcel(Region region) {
        try {
            List<Region> list = this.regionService.findAll(region);
            return FileUtils.createExcelByPOIKit("区域表", list, Region.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("region/csv")
    @ResponseBody
    public ResponseBo roleCsv(Region region) {
        try {
            List<Region> list = this.regionService.findAll(region);
            return FileUtils.createCsv("区域表", list, Region.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
