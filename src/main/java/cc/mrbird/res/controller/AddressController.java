package cc.mrbird.res.controller;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.res.domain.Address;
import cc.mrbird.res.service.AddressService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * AddressController
 *
 * @author: fengwang
 * @date: 2019-02-22 14:53
 * @version: 1.0
 * @since: JDK 1.8
 */
@Controller
public class AddressController extends BaseController {
    @Autowired
    private AddressService addressService;

    @Log("获取标准地址信息")
    @RequestMapping("address")
    @RequiresPermissions("address:list")
    public String index() {
        return "res/address/index";
    }

    @RequestMapping("address/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Address address) {
        return super.selectByPageNumSize(request, () -> this.addressService.findAll(address));
    }

    @RequestMapping("address/excel")
    @ResponseBody
    public ResponseBo excel(Address address) {
        try {
            List<Address> list = this.addressService.findAll(address);
            return FileUtils.createExcelByPOIKit("标准地址表", list, Address.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("address/csv")
    @ResponseBody
    public ResponseBo csv(Address address) {
        try {
            List<Address> list = this.addressService.findAll(address);
            return FileUtils.createCsv("标准地址表", list, Address.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
