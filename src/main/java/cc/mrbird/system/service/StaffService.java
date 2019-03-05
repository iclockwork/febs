package cc.mrbird.system.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.system.domain.Staff;

import java.util.List;

/**
 * StaffService
 *
 * @author: fengwang
 * @date: 2019-03-05 11:14
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface StaffService extends IService<Staff> {
    List<Staff> findAll(Staff staff);
}
