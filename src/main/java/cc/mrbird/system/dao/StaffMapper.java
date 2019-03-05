package cc.mrbird.system.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.system.domain.Staff;

import java.util.List;

public interface StaffMapper extends MyMapper<Staff> {
    List<Staff> findAll(Staff staff);
}