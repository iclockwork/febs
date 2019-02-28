package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CompProductMapper;
import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.defineConstant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
@Service("compProductService")
public class CompProductServiceImpl implements CompProductService {
    @Autowired
     private CompProductMapper compProductMapper;


    @Override
    public List<CompProduct> queryCompProduct(CompProduct compProduct) {
        return compProductMapper.queryCompProduct(compProduct);
    }

    @Override
    public void addCompProduct(CompProduct compProduct) {
        compProduct.setDeleteFlag(CommonConstant.VALID);
        compProduct.setCreateDate(new Date());
        compProduct.setCreateStaffId(12345);
        compProductMapper.addCompProduct(compProduct);
    }

    @Override
    public CompProduct findById(Long compProductId) {
        return compProductMapper.findById(compProductId);
    }

    @Override
    public void updateCompProduct(CompProduct compProduct) {
        compProductMapper.updateCompProduct(compProduct);
    }

    @Override
    public void deleteCompProduct(Long compProductId) {
        compProductMapper.deleteCompProduct(compProductId);
    }
}
