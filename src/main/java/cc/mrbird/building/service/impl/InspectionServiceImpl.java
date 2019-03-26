package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.InspectionMapper;
import cc.mrbird.building.domain.Inspection;
import cc.mrbird.building.service.InspectionService;
import cc.mrbird.common.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * InspectionServiceImpl
 *
 * @author: fengwang
 * @date: 2019-03-25 15:32
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("inspectionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class InspectionServiceImpl extends BaseService<Inspection> implements InspectionService {
    @Autowired
    private InspectionMapper inspectionMapper;

    @Override
    public List<Inspection> findAll(Inspection inspection) {
        try {
            return this.inspectionMapper.findAll(inspection);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
