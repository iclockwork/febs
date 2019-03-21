package cc.mrbird.building.controller;

import cc.mrbird.building.domain.Customer;
import cc.mrbird.building.service.CustomerService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * CustomerController
 *
 * @author: fengwang
 * @date: 2019-02-27 15:12
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;

    @Log("获取客户信息")
    @RequestMapping("customer")
    @RequiresPermissions("customer:list")
    public String index() {
        return "building/customer/index";
    }

    @RequestMapping("customer/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Customer customer) {
        if (StringUtils.isBlank(customer.getDsRegionId())) {
            customer.setDsRegionId(super.getCurrentUser().getRegionId());
        }
        return super.selectByPageNumSize(request, () -> this.customerService.findAll(customer));
    }

    @RequestMapping("customer/excel")
    @ResponseBody
    public ResponseBo excel(Customer customer) {
        try {
            List<Customer> list = this.customerService.findAll(customer);
            return FileUtils.createExcelByPOIKit("客户表", list, Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customer/csv")
    @ResponseBody
    public ResponseBo csv(Customer customer) {
        try {
            List<Customer> list = this.customerService.findAll(customer);
            return FileUtils.createCsv("客户表", list, Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
