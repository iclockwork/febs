package cc.mrbird.system.controller;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.Staff;
import cc.mrbird.system.service.StaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * StaffController
 *
 * @author: fengwang
 * @date: 2019-03-05 11:17
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class StaffController extends BaseController {
    @Autowired
    private StaffService staffService;

    @Log("获取人员信息")
    @RequestMapping("staff")
    @RequiresPermissions("staff:list")
    public String index() {
        return "system/staff/index";
    }

    @RequestMapping("staff/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Staff staff) {
        return super.selectByPageNumSize(request, () -> this.staffService.findAll(staff));
    }

    @RequestMapping("staff/excel")
    @ResponseBody
    public ResponseBo excel(Staff staff) {
        try {
            List<Staff> list = this.staffService.findAll(staff);
            return FileUtils.createExcelByPOIKit("人员表", list, Staff.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("staff/csv")
    @ResponseBody
    public ResponseBo csv(Staff staff) {
        try {
            List<Staff> list = this.staffService.findAll(staff);
            return FileUtils.createCsv("人员表", list, Staff.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
