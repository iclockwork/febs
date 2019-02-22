package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.BusinessOpportunityMapper;
import cc.mrbird.building.domain.BusinessOpportunityEntity;
import cc.mrbird.building.service.BusinessOpportunityService;
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
@Service("businessOpportunityService")
public class BusinessOpportunityServiceImpl implements BusinessOpportunityService {
    @Autowired
     private BusinessOpportunityMapper businessOpportunityDao;

    @Override
    public List<BusinessOpportunityEntity> queryBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity, QueryRequest request) {
        return  businessOpportunityDao.queryBusinessOpportunity(businessOpportunityEntity);
    }

    @Override
    public void addBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity) {
        businessOpportunityEntity.setBuildingId(12345677L);
        businessOpportunityEntity.setDeleteFlag(0);
        businessOpportunityEntity.setCreateDate(new Date());
        businessOpportunityEntity.setCreateStaffId(12345L);
        businessOpportunityDao.addBusinessOpportunity(businessOpportunityEntity);
    }

    @Override
    public BusinessOpportunityEntity findById(Long businessOpportunityId) {

        return  businessOpportunityDao.findById(businessOpportunityId);
    }

    @Override
    public void updateBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity) {
        businessOpportunityDao.updateBusinessOpportunity(businessOpportunityEntity);
    }
}
