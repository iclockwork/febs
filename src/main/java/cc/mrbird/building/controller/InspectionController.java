package cc.mrbird.building.controller;

import cc.mrbird.building.domain.Inspection;
import cc.mrbird.building.service.InspectionService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * InspectionController
 *
 * @author: fengwang
 * @date: 2019-03-25 15:35
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class InspectionController extends BaseController {
    @Autowired
    private InspectionService inspectionService;

    @Log("获取巡检记录")
    @RequestMapping("inspection")
    public String index() {
        return "building/inspection/index";
    }

    @RequestMapping("inspection/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Inspection inspection) {
        return super.selectByPageNumSize(request, () -> this.inspectionService.findAll(inspection));
    }

    @RequestMapping("inspection/excel")
    @ResponseBody
    public ResponseBo excel(Inspection inspection) {
        try {
            List<Inspection> list = this.inspectionService.findAll(inspection);
            return FileUtils.createExcelByPOIKit("巡检记录表", list, Inspection.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("inspection/csv")
    @ResponseBody
    public ResponseBo csv(Inspection inspection) {
        try {
            List<Inspection> list = this.inspectionService.findAll(inspection);
            return FileUtils.createCsv("巡检记录表", list, Inspection.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
