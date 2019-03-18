package cc.mrbird.res.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.res.domain.Room;

import java.util.List;

public interface RoomMapper extends MyMapper<Room> {
    List<Room> findAll(Room room);
}