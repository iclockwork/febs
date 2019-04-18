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

    @RequestMapping("customerBusiness/listByBuilding")
    @ResponseBody
    public Map<String, Object> listByBuilding(QueryRequest request, String buildingNo) {
        return super.selectByPageNumSize(request, () -> this.customerBusinessService.findAllByBuilding(buildingNo));
    }

    @RequestMapping("customerBusiness/listByBuildingExcel")
    @ResponseBody
    public ResponseBo listByBuildingExcel(String buildingNo) {
        try {
            List<CustomerBusiness> list = this.customerBusinessService.findAllByBuilding(buildingNo);
            return FileUtils.createExcelByPOIKit("客户业务表", list, CustomerBusiness.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerBusiness/listByBuildingCsv")
    @ResponseBody
    public ResponseBo listByBuildingCsv(String buildingNo) {
        try {
            List<CustomerBusiness> list = this.customerBusinessService.findAllByBuilding(buildingNo);
            return FileUtils.createCsv("客户业务表", list, CustomerBusiness.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerBusiness/countByBuilding")
    @ResponseBody
    public Map<String, Object> countByBuilding(QueryRequest request, String buildingNo) {
        try {
            List<CustomerBusiness> list = this.customerBusinessService.countByBuilding(buildingNo);
            return ResponseBo.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取客户业务量失败，请联系网站管理员！");
        }
    }

    @RequestMapping("customerBusiness/sumMonthFeeByBuilding")
    @ResponseBody
    public Map<String, Object> sumMonthFeeByBuilding(QueryRequest request, String buildingNo) {
        try {
            List<CustomerBusiness> list = this.customerBusinessService.sumMonthFeeByBuilding(buildingNo);
            return ResponseBo.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取客户业务收入失败，请联系网站管理员！");
        }
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

    @RequestMapping("customerBusiness/getCustomerBusiness")
    @ResponseBody
    public ResponseBo get(Long customerBusinessId) {
        try {
            CustomerBusiness customerBusiness = this.customerBusinessService.findById(customerBusinessId);
            return ResponseBo.ok(customerBusiness);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取客户业务信息失败，请联系网站管理员！");
        }
    }

    @Log("新增客户业务")
    @RequestMapping("customerBusiness/add")
    @ResponseBody
    public ResponseBo add(CustomerBusiness customerBusiness) {
        try {
            customerBusiness.setCreateStaffId(super.getCurrentUser().getStaffId());
            this.customerBusinessService.add(customerBusiness);
            return ResponseBo.ok("新增客户业务成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增客户业务失败，请联系网站管理员！");
        }
    }

    @Log("修改客户业务")
    @RequestMapping("customerBusiness/update")
    @ResponseBody
    public ResponseBo update(CustomerBusiness customerBusiness) {
        try {
            customerBusiness.setModifyStaffId(super.getCurrentUser().getStaffId());
            this.customerBusinessService.update(customerBusiness);
            return ResponseBo.ok("修改客户业务成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改客户业务失败，请联系网站管理员！");
        }
    }

    @Log("删除客户业务")
    @RequestMapping("customerBusiness/delete")
    @ResponseBody
    public ResponseBo delete(String customerBusinessIds) {
        try {
            Long staffId = super.getCurrentUser().getStaffId();
            this.customerBusinessService.delete(customerBusinessIds, staffId);
            return ResponseBo.ok("删除楼宇成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除楼宇失败，请联系网站管理员！");
        }
    }
}
