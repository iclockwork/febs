package cc.mrbird.building.controller;

import cc.mrbird.building.domain.BusinessOpportunityEntity;
import cc.mrbird.building.service.BusinessOpportunityService;
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
 * Features:
 */

@Controller
public class BusinessOpportunityController extends BaseController {


    @Autowired
    private BusinessOpportunityService businessOpportunityService;

    @Log("获取商机信息")
    @RequestMapping("businessOpportunity")
    @RequiresPermissions("businessOpportunity:list")
    public String index() {
        return "building/businessOpportunity/businessOpportunity";
    }

    @RequestMapping("businessOpportunity/list")
    @ResponseBody
    public Map<String, Object> queryBusinessOpportunity(QueryRequest request, BusinessOpportunityEntity businessOpportunityEntity) {

        return  super.selectByPageNumSize(request, () -> this.businessOpportunityService.queryBusinessOpportunity(businessOpportunityEntity, request));
    }

    @RequestMapping("businessOpportunity/excel")
    @ResponseBody
    public ResponseBo exportExcel(BusinessOpportunityEntity businessOpportunityEntity,QueryRequest request) {
        try {
            List<BusinessOpportunityEntity> list = this.businessOpportunityService.queryBusinessOpportunity(businessOpportunityEntity, request);
            return FileUtils.createExcelByPOIKit("商机表", list, BusinessOpportunityEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("businessOpportunity/csv")
    @ResponseBody
    public ResponseBo exportCsv(BusinessOpportunityEntity businessOpportunityEntity,QueryRequest request) {
        try {
            List<BusinessOpportunityEntity> list = this.businessOpportunityService.queryBusinessOpportunity(businessOpportunityEntity,request);
            return FileUtils.createCsv("商机表", list, BusinessOpportunityEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }

    @Log("新增商机")
    @RequiresPermissions("businessOpportunity:add")
    @RequestMapping("businessOpportunity/add")
    @ResponseBody
    public ResponseBo addBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity) {
        try {

            this.businessOpportunityService.addBusinessOpportunity(businessOpportunityEntity);
            return ResponseBo.ok("新增商机成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增商机失败，请联系网站管理员！");
        }
    }

    @RequestMapping("businessOpportunity/getBusinessOpportunity")
    @ResponseBody
    public ResponseBo getBusinessOpportunity(Long businessOpportunityId) {
        try {
            BusinessOpportunityEntity businessOpportunityEntity  = this.businessOpportunityService.findById(businessOpportunityId);
            return ResponseBo.ok(businessOpportunityEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取商机信息失败，请联系网站管理员！");
        }
    }


    @Log("修改商机")
    @RequiresPermissions("businessOpportunity:update")
    @RequestMapping("businessOpportunity/update")
    @ResponseBody
    public ResponseBo updateBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity) {
        try {
            this.businessOpportunityService.updateBusinessOpportunity(businessOpportunityEntity);
            return ResponseBo.ok("修改商机成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改商机失败，请联系网站管理员！");
        }
    }

//    @Log("删除用户")
//    @RequiresPermissions("businessOpportunity:delete")
//    @RequestMapping("businessOpportunity/delete")
//    @ResponseBody
//    public ResponseBo deleteBusinessOpportunity(Long businessOpportunityId) {
//        try {
//            this.businessOpportunityService.deleteBusinessOpportunity(businessOpportunityId);
//            return ResponseBo.ok("删除用户成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("删除用户失败，请联系网站管理员！");
//        }
//    }


}
