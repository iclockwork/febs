package cc.mrbird.building.service;


import cc.mrbird.building.domain.CompProduct;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /22
 * Features:
 */
public interface CompProductService {

    List<CompProduct> queryCompProduct(CompProduct compProduct);

}
