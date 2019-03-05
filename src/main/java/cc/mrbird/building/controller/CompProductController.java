package cc.mrbird.building.controller;


import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.Constant;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.system.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
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
    private final static Logger logger = LoggerFactory.getLogger(CompProductController.class);


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

        return super.selectByPageNumSize(request, () -> this.compProductService.queryCompProduct(compProduct));
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
    public ResponseBo exportCsv(CompProduct compProduct, QueryRequest request) {
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
            User user = super.getCurrentUser();
            Long staffId = user.getStaffId();
            compProduct.setCreateStaffId(staffId);
            this.compProductService.addCompProduct(compProduct);
            if (compProduct.getUploadFlag().equalsIgnoreCase(Constant.UPLOAD_FLAG_YES)) {
                this.compProductService.addCompProductDoc(compProduct);
            }
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
            if (compProduct.getUploadFlag().equalsIgnoreCase(Constant.UPLOAD_FLAG_YES)) {
                if (this.compProductService.queryDocByCompProductId(compProduct.getCompProductId()) != null) {
                    this.compProductService.updateCompProductDoc(compProduct);
                } else {
                    this.compProductService.addCompProductDoc(compProduct);
                }
            }
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
            this.compProductService.deleteCompProduct(ids);
            return ResponseBo.ok("删除竞争产品成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除竞争产品失败，请联系网站管理员！");
        }
    }

    @RequestMapping("compProduct/upload")
    @ResponseBody
    public ResponseBo upload(HttpServletResponse response, HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            /** 页面控件的文件流* */
            MultipartFile multipartFile = null;
            Map map = multipartRequest.getFileMap();
            for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
                Object obj = i.next();
                multipartFile = (MultipartFile) map.get(obj);

            }
            /** 获取文件的后缀* */
            String filename = multipartFile.getOriginalFilename();
            String tempPath = System.getProperty("java.io.tmpdir");
            File file = new File(tempPath);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    logger.info("创建目录失败！");
                }
            }
            String filePath = file.getPath() + "\\" + filename;
            File xmlFile = new File(filePath);
            if (xmlFile.exists()) {
                if (!xmlFile.delete()) {
                    logger.info("文件删除失败！");
                }
            }
            multipartFile.transferTo(xmlFile);

            this.compProductService.saveFile(filePath, filename);

            return ResponseBo.ok(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("上传失败，请联系网站管理员！");
        }
    }


    @RequestMapping("compProduct/queryDoc")
    @ResponseBody
    public ResponseBo queryDoc(Long compProductId) {
        try {
            Long docId = this.compProductService.queryDocByCompProductId(compProductId);
            return ResponseBo.ok(docId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取附件内容失败，请联系网站管理员！");
        }
    }

    @RequestMapping("compProduct/downloadDoc")
    @ResponseBody
    public ResponseBo downloadDoc(@PathParam("docId") Long docId, HttpServletResponse response,HttpServletRequest request) {
        try {
            CompProduct compProduct = this.compProductService.queryDocById(docId);
            byte[] fileContent = compProduct.getFileContent();
            OutputStream outputStream = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(fileContent);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.close();
            in.close();
            return ResponseBo.ok("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取附件内容失败，请联系网站管理员！");
        }
    }
}
