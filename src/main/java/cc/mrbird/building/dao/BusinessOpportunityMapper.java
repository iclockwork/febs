package cc.mrbird.building.dao;


import cc.mrbird.building.domain.BusinessOpportunityEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ 2/22
 * Features:
 */
@Mapper
public interface BusinessOpportunityMapper {

    List<BusinessOpportunityEntity> queryBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity);

    void addBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity);

    BusinessOpportunityEntity findById(Long businessOpportunityId);

    void updateBusinessOpportunity(BusinessOpportunityEntity businessOpportunityEntity);
}
