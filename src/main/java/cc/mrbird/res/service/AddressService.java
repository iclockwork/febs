package cc.mrbird.res.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.res.domain.Address;

import java.util.List;

/**
 * AddressService
 *
 * @author: fengwang
 * @date: 2019-02-22 14:50
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface AddressService extends IService<Address> {
    List<Address> findAll(Address address);
}
