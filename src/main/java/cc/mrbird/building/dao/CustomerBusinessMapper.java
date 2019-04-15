package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CustomerBusiness;
import cc.mrbird.common.config.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerBusinessMapper extends MyMapper<CustomerBusiness> {
    List<CustomerBusiness> findAll(CustomerBusiness customerBusiness);

    List<CustomerBusiness> findAllByBuilding(@Param("buildingNo") String buildingNo);

    List<CustomerBusiness> countByBuilding(@Param("buildingNo") String buildingNo);

    List<CustomerBusiness> sumMonthFeeByBuilding(@Param("buildingNo") String buildingNo);

    CustomerBusiness findById(Long customerBusinessId);

    Long findTotal(CustomerBusiness customerBusiness);

    BigDecimal monthFeeTotal(CustomerBusiness customerBusiness);
}