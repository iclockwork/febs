package cc.mrbird.res.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.res.domain.Room;

import java.util.List;

/**
 * TRoomService
 *
 * @author: fengwang
 * @date: 2019-02-22 10:33
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface RoomService extends IService<Room> {
    List<Room> findAll(Room room);
}
