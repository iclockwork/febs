package cc.mrbird.system.controller;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.Restriction;
import cc.mrbird.system.service.RestrictionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * RestrictionController
 *
 * @author: fengwang
 * @date: 2019-02-28 14:56
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class RestrictionController extends BaseController {
    @Autowired
    private RestrictionService restrictionService;

    @Log("获取属性信息")
    @RequestMapping("restriction")
    @RequiresPermissions("restriction:list")
    public String index() {
        return "system/restriction/index";
    }

    @RequestMapping("restriction/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Restriction restriction) {
        return super.selectByPageNumSize(request, () -> this.restrictionService.findAll(restriction));
    }

    @RequestMapping("restriction/excel")
    @ResponseBody
    public ResponseBo excel(Restriction restriction) {
        try {
            List<Restriction> list = this.restrictionService.findAll(restriction);
            return FileUtils.createExcelByPOIKit("属性表", list, Restriction.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("restriction/csv")
    @ResponseBody
    public ResponseBo csv(Restriction restriction) {
        try {
            List<Restriction> list = this.restrictionService.findAll(restriction);
            return FileUtils.createCsv("属性表", list, Restriction.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
