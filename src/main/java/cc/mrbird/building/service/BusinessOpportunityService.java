package cc.mrbird.building.service;


import cc.mrbird.building.domain.BusinessOpportunityEntity;
import cc.mrbird.common.domain.QueryRequest;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ /
 * Features:
 */
public interface BusinessOpportunityService {

    List<BusinessOpportunityEntity> queryBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity, QueryRequest request);

    void addBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity);

    BusinessOpportunityEntity findById(Long businessOpportunityId);

    void updateBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity);
}
