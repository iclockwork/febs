package cc.mrbird.building.controller;


import cc.mrbird.building.domain.CustomerExpiration;
import cc.mrbird.building.domain.CustomerOpportunity;
import cc.mrbird.building.service.CustomerOpportunityService;
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
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /18
 * Features:商机客户
 */

@Controller
public class CustomerOpportunityController extends BaseController {


    @Autowired
    private CustomerOpportunityService customerOpportunityService;

    @Log("获取商机客户信息")
    @RequestMapping("customerOpportunity")
    @RequiresPermissions("customerOpportunity:list")
    public String index() {
        return "building/customerOpportunity/customerOpportunity";
    }

    @RequestMapping("customerOpportunity/list")
    @ResponseBody
    public Map<String, Object> queryCustomerOpportunity(QueryRequest request, CustomerOpportunity customerOpportunity) {

        return  super.selectByPageNumSize(request, () -> this.customerOpportunityService.queryCustomerOpportunity(customerOpportunity));
    }

    @RequestMapping("customerOpportunity/excel")
    @ResponseBody
    public ResponseBo exportExcel(CustomerOpportunity customerOpportunity,QueryRequest request) {
        try {
            List<CustomerOpportunity> list = this.customerOpportunityService.queryCustomerOpportunity(customerOpportunity);
            return FileUtils.createExcelByPOIKit("商机客户表", list, CustomerExpiration.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerOpportunity/csv")
    @ResponseBody
    public ResponseBo exportCsv(CustomerOpportunity customerOpportunity,QueryRequest request) {
        try {
            List<CustomerOpportunity> list = this.customerOpportunityService.queryCustomerOpportunity(customerOpportunity);
            return FileUtils.createCsv("商机客户表", list, CustomerExpiration.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @Log("新增商机客户")
    @RequiresPermissions("customerOpportunity:add")
    @RequestMapping("customerOpportunity/add")
    @ResponseBody
    public ResponseBo addCustomerOpportunity(CustomerOpportunity customerOpportunity) {
        try {

            this.customerOpportunityService.addCustomerOpportunity(customerOpportunity);
            return ResponseBo.ok("新增商机客户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增商机客户失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerOpportunity/getCustomerOpportunity")
    @ResponseBody
    public ResponseBo getCustomerOpportunity(Long customerId) {
        try {
            CustomerOpportunity customerOpportunity  = this.customerOpportunityService.findById(customerId);
            return ResponseBo.ok(customerOpportunity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取商机客户信息失败，请联系网站管理员！");
        }
    }


    @Log("修改商机客户")
    @RequiresPermissions("customerOpportunity:update")
    @RequestMapping("customerOpportunity/update")
    @ResponseBody
    public ResponseBo updateCustomerOpportunity(CustomerOpportunity customerExpiration) {
        try {
            this.customerOpportunityService.updateCustomerOpportunity(customerExpiration);
            return ResponseBo.ok("修改商机客户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改商机客户失败，请联系网站管理员！");
        }
    }

    @Log("删除商机楼宇")
    @RequiresPermissions("customerOpportunity:delete")
    @RequestMapping("customerOpportunity/delete")
    @ResponseBody
    public ResponseBo deleteCustomerOpportunity(String ids) {
        try {
            this.customerOpportunityService.deleteCustomerOpportunity(ids);
            return ResponseBo.ok("删除商机客户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除商机客户失败，请联系网站管理员！");
        }
    }
}
