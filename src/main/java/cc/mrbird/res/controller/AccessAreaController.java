package cc.mrbird.res.controller;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.res.domain.AccessArea;
import cc.mrbird.res.service.AccessAreaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * AccessAreaController
 *
 * @author: fengwang
 * @date: 2019-02-21 16:23
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class AccessAreaController extends BaseController {
    @Autowired
    private AccessAreaService accessAreaService;

    @Log("获取综合接入区信息")
    @RequestMapping("accessArea")
    @RequiresPermissions("accessArea:list")
    public String index() {
        return "res/accessArea/index";
    }

    @RequestMapping("accessArea/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, AccessArea accessArea) {
        return super.selectByPageNumSize(request, () -> this.accessAreaService.findAll(accessArea));
    }

    @RequestMapping("accessArea/excel")
    @ResponseBody
    public ResponseBo excel(AccessArea accessArea) {
        try {
            List<AccessArea> list = this.accessAreaService.findAll(accessArea);
            return FileUtils.createExcelByPOIKit("综合接入区表", list, AccessArea.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("accessArea/csv")
    @ResponseBody
    public ResponseBo csv(AccessArea accessArea) {
        try {
            List<AccessArea> list = this.accessAreaService.findAll(accessArea);
            return FileUtils.createCsv("综合接入区表", list, AccessArea.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
