package cc.mrbird.building.controller;


import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//
//    @RequestMapping("businessOpportunity/excel")
//    @ResponseBody
//    public ResponseBo exportExcel(BusinessOpportunityEntity businessOpportunityEntity,QueryRequest request) {
//        try {
//            List<BusinessOpportunityEntity> list = this.businessOpportunityService.queryBusinessOpportunity(businessOpportunityEntity, request);
//            return FileUtils.createExcelByPOIKit("商机表", list, BusinessOpportunityEntity.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("businessOpportunity/csv")
//    @ResponseBody
//    public ResponseBo exportCsv(BusinessOpportunityEntity businessOpportunityEntity,QueryRequest request) {
//        try {
//            List<BusinessOpportunityEntity> list = this.businessOpportunityService.queryBusinessOpportunity(businessOpportunityEntity,request);
//            return FileUtils.createCsv("商机表", list, BusinessOpportunityEntity.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
//        }
//    }
//
//    @Log("新增商机")
//    @RequiresPermissions("businessOpportunity:add")
//    @RequestMapping("businessOpportunity/add")
//    @ResponseBody
//    public ResponseBo addBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity) {
//        try {
//
//            this.businessOpportunityService.addBusinessOpportunity(businessOpportunityEntity);
//            return ResponseBo.ok("新增商机成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("新增商机失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("businessOpportunity/getBusinessOpportunity")
//    @ResponseBody
//    public ResponseBo getBusinessOpportunity(Long businessOpportunityId) {
//        try {
//            BusinessOpportunityEntity businessOpportunityEntity  = this.businessOpportunityService.findById(businessOpportunityId);
//            return ResponseBo.ok(businessOpportunityEntity);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("获取商机信息失败，请联系网站管理员！");
//        }
//    }


//    @Log("修改商机")
//    @RequiresPermissions("businessOpportunity:update")
//    @RequestMapping("businessOpportunity/update")
//    @ResponseBody
//    public ResponseBo updateUser(User user, Long[] rolesSelect) {
//        try {
//            if (ON.equalsIgnoreCase(user.getStatus()))
//                user.setStatus("1");
//            else
//                user.setStatus("0");
//            this.userService.updateUser(user, rolesSelect);
//            return ResponseBo.ok("修改用户成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("修改用户失败，请联系网站管理员！");
//        }
//    }
//
//    @Log("删除用户")
//    @RequiresPermissions("user:delete")
//    @RequestMapping("user/delete")
//    @ResponseBody
//    public ResponseBo deleteUsers(String ids) {
//        try {
//            this.userService.deleteUsers(ids);
//            return ResponseBo.ok("删除用户成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("删除用户失败，请联系网站管理员！");
//        }
//    }


}
