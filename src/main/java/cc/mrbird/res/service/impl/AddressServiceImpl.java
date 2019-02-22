package cc.mrbird.res.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.res.dao.AddressMapper;
import cc.mrbird.res.domain.Address;
import cc.mrbird.res.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * AddressServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-22 14:51
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("addressService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AddressServiceImpl extends BaseService<Address> implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAll(Address address) {
        try {
            List<Address> list = this.addressMapper.findAll(address.getStandName());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
