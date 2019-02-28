package cc.mrbird.building.controller;


import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.defineConstant.CommonConstant;
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
 * Features:
 */

@Controller
public class CompProductController extends BaseController {


    @Autowired
    private CompProductService compProductService;

    @Log("获取竞争产品信息")
    @RequestMapping("compProduct")
    @RequiresPermissions("compProduct:list")
    public String index() {
        return "building/compProduct/compProduct";
    }

    @RequestMapping("compProduct/list")
    @ResponseBody
    public Map<String, Object> queryCompProduct(QueryRequest request, CompProduct compProduct) {

        return  super.selectByPageNumSize(request, () -> this.compProductService.queryCompProduct(compProduct));
    }

    @RequestMapping("compProduct/excel")
    @ResponseBody
    public ResponseBo exportExcel(CompProduct compProduct, QueryRequest request) {
        try {
            List<CompProduct> list = this.compProductService.queryCompProduct(compProduct);
            return FileUtils.createExcelByPOIKit("竞争产品表", list, CompProduct.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("compProduct/csv")
    @ResponseBody
    public ResponseBo exportCsv(CompProduct compProduct,QueryRequest request) {
        try {
            List<CompProduct> list = this.compProductService.queryCompProduct(compProduct);
            return FileUtils.createCsv("竞争产品表", list, CompProduct.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @Log("新增竞争产品")
    @RequiresPermissions("compProduct:add")
    @RequestMapping("compProduct/add")
    @ResponseBody
    public ResponseBo addCompProduct(CompProduct compProduct) {
        try {

            this.compProductService.addCompProduct(compProduct);
            return ResponseBo.ok("新增竞争产品成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增竞争产品失败，请联系网站管理员！");
        }
    }

    @RequestMapping("compProduct/getCompProduct")
    @ResponseBody
    public ResponseBo getCompProduct(Long compProductId) {
        try {
            CompProduct compProduct = this.compProductService.findById(compProductId);
            return ResponseBo.ok(compProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取商机信息失败，请联系网站管理员！");
        }
    }


    @Log("修改竞争产品")
    @RequiresPermissions("compProduct:update")
    @RequestMapping("compProduct/update")
    @ResponseBody
    public ResponseBo updateCompProduct(CompProduct compProduct) {
        try {
            this.compProductService.updateCompProduct(compProduct);
            return ResponseBo.ok("修改竞争产品成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改竞争产品失败，请联系网站管理员！");
        }
    }


    @Log("删除竞争产品")
    @RequiresPermissions("compProduct:delete")
    @RequestMapping("compProduct/delete")
    @ResponseBody
    public ResponseBo deleteCompProduct(String ids) {
        try {
            //声明删除标记
            short deleteFlag = CommonConstant.INVALID;
            this.compProductService.deleteCompProduct(ids,deleteFlag);
            return ResponseBo.ok("删除竞争产品成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除竞争产品失败，请联系网站管理员！");
        }
    }

}
