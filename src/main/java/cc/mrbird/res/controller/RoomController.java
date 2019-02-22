package cc.mrbird.res.controller;

import cc.mrbird.common.annotation.Log;
import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.res.domain.Room;
import cc.mrbird.res.service.RoomService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * RoomController
 *
 * @author: fengwang
 * @date: 2019-02-22 10:38
 * @version: 1.0
 * @since: JDK 1.7
 */
@Controller
public class RoomController extends BaseController {
    @Autowired
    private RoomService roomService;

    @Log("获取机房信息")
    @RequestMapping("room")
    @RequiresPermissions("room:list")
    public String index() {
        return "res/room/index";
    }

    @RequestMapping("room/list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Room room) {
        return super.selectByPageNumSize(request, () -> this.roomService.findAll(room));
    }

    @RequestMapping("room/excel")
    @ResponseBody
    public ResponseBo excel(Room room) {
        try {
            List<Room> list = this.roomService.findAll(room);
            return FileUtils.createExcelByPOIKit("机房表", list, Room.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequestMapping("room/csv")
    @ResponseBody
    public ResponseBo csv(Room room) {
        try {
            List<Room> list = this.roomService.findAll(room);
            return FileUtils.createCsv("机房表", list, Room.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("导出Csv失败，请联系网站管理员！");
        }
    }
}
