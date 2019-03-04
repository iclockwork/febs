package cc.mrbird.building.dao;

import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.common.config.MyMapper;

import java.io.ByteArrayInputStream;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/ 2/22
 * Features:
 */
public interface CompProductMapper extends MyMapper<CompProduct> {

    List<CompProduct> queryCompProduct(CompProduct compProduct);

    void addCompProduct(CompProduct compProduct);

    CompProduct findById(Long compProductId);

    void updateCompProduct(CompProduct compProduct);

    void deleteCompProduct(int[] ids);

    void saveFile(ByteArrayInputStream fileInput, String filename);

    void addCompProductDoc(CompProduct compProduct);

    void updateCompProductDoc(CompProduct compProduct);

    Long getDocId();

    Long queryDocByCompProductId(Long compProductId);

}