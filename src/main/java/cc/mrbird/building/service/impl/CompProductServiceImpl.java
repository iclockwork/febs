package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BusinessOpportunityMapper;
import cc.mrbird.building.dao.CompProductMapper;
import cc.mrbird.building.domain.BusinessOpportunityEntity;
import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.BusinessOpportunityService;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.common.domain.QueryRequest;
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
}
