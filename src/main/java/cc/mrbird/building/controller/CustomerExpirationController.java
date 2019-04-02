package cc.mrbird.building.controller;


import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.building.service.CustomerExpirationService;
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
 * Features:客户到期提醒
 */

@Controller
public class CustomerExpirationController extends BaseController {


    @Autowired
    private CustomerExpirationService customerExpirationService;

    @Log("获取客户到期提醒信息")
    @RequestMapping("customerExpiration")
    @RequiresPermissions("customerExpiration:list")
    public String index() {
        return "building/customerExpiration/customerExpiration";
    }

    @RequestMapping("customerExpiration/list")
    @ResponseBody
    public Map<String, Object> queryCustomerExpiration(QueryRequest request, CustomerExpiration customerExpiration) {
        return  super.selectByPageNumSize(request, () -> this.customerExpirationService.queryCustomerExpiration(workingCondition(customerExpiration)));
    }

    @RequestMapping("customerExpiration/excel")
    @ResponseBody
    public ResponseBo exportExcel(CustomerExpiration customerExpiration,QueryRequest request) {
        try {
            List<CustomerExpiration> list = this.customerExpirationService.queryCustomerExpiration(workingCondition(customerExpiration));
            return FileUtils.createExcelByPOIKit("客户到期提醒表", list, CustomerExpiration.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerExpiration/csv")
    @ResponseBody
    public ResponseBo exportCsv(CustomerExpiration customerExpiration,QueryRequest request) {
        try {
            List<CustomerExpiration> list = this.customerExpirationService.queryCustomerExpiration(workingCondition(customerExpiration));
            return FileUtils.createCsv("客户到期提醒表", list, CustomerExpiration.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @Log("新增客户到期提醒")
    @RequiresPermissions("customerExpiration:add")
    @RequestMapping("customerExpiration/add")
    @ResponseBody
    public ResponseBo addCustomerExpiration(CustomerExpiration customerExpiration) {
        try {

            this.customerExpirationService.addCustomerExpiration(customerExpiration);
            return ResponseBo.ok("新增客户到期提醒成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增客户到期提醒失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerExpiration/getCustomerExpiration")
    @ResponseBody
    public ResponseBo getCustomerExpiration(Long customerExpirationId) {
        try {
            CustomerExpiration customerExpiration  = this.customerExpirationService.findById(customerExpirationId);
            return ResponseBo.ok(customerExpiration);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取客户到期提醒信息失败，请联系网站管理员！");
        }
    }


    @Log("修改客户到期提醒")
    @RequiresPermissions("customerExpiration:update")
    @RequestMapping("customerExpiration/update")
    @ResponseBody
    public ResponseBo updateCustomerExpiration(CustomerExpiration customerExpiration) {
        try {
            this.customerExpirationService.updateCustomerExpiration(customerExpiration);
            return ResponseBo.ok("修改客户到期提醒成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改客户到期提醒失败，请联系网站管理员！");
        }
    }

    @Log("删除客户到期提醒")
    @RequiresPermissions("customerExpiration:delete")
    @RequestMapping("customerExpiration/delete")
    @ResponseBody
    public ResponseBo deleteCustomerExpiration(String ids) {
        try {
            this.customerExpirationService.deleteCustomerExpiration(ids);
            return ResponseBo.ok("删除客户到期提醒成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除客户到期提醒失败，请联系网站管理员！");
        }
    }

    private CustomerExpiration workingCondition(CustomerExpiration customerExpiration) {
        User currentUser = super.getCurrentUser();
        if (StringUtils.isBlank(customerExpiration.getDsRegionId())) {
            customerExpiration.setDsRegionId(currentUser.getRegionId());
        }
        if (Constant.STAFF_TYPE_NORMAL.equals(currentUser.getStaffType())) {
            customerExpiration.setCreateStaffId(currentUser.getStaffId());
        }
        return customerExpiration;
    }
}
