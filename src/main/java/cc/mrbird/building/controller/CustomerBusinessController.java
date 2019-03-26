package cc.mrbird.building.controller;

import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.building.service.CustomerBusinessService;
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
 * CustomerBusinessController
 *
 * @author: fengwang
 * @date: 2019-03-26 16:34
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class CustomerBusinessController extends BaseController {
    @Autowired
    private CustomerBusinessService customerBusinessService;

    @Log("获取客户业务")
    @RequestMapping("customerBusiness")
    public String index() {
        return "building/customerBusiness/index";
    }

    @RequestMapping("customerBusiness/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, CustomerBusiness customerBusiness) {
        return super.selectByPageNumSize(request, () -> this.customerBusinessService.findAll(customerBusiness));
    }

    @RequestMapping("customerBusiness/excel")
    @ResponseBody
    public ResponseBo excel(CustomerBusiness customerBusiness) {
        try {
            List<CustomerBusiness> list = this.customerBusinessService.findAll(customerBusiness);
            return FileUtils.createExcelByPOIKit("客户业务表", list, CustomerBusiness.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerBusiness/csv")
    @ResponseBody
    public ResponseBo csv(CustomerBusiness customerBusiness) {
        try {
            List<CustomerBusiness> list = this.customerBusinessService.findAll(customerBusiness);
            return FileUtils.createCsv("客户业务表", list, CustomerBusiness.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
