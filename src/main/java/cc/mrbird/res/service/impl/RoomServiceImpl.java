package cc.mrbird.res.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.res.dao.RoomMapper;
import cc.mrbird.res.domain.Room;
import cc.mrbird.res.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * RoomServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-22 10:35
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("roomService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoomServiceImpl extends BaseService<Room> implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> findAll(Room room) {
        try {
            return this.roomMapper.findAll(room);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
