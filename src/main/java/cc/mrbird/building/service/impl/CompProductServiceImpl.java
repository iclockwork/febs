package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CompProductMapper;
import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.common.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
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
        compProduct.setDeleteFlag(Short.valueOf(Constant.DELETE_FLAG_NO));
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
    public void deleteCompProduct(String ids) {
        int[] ints = Arrays.stream(ids.split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        compProductMapper.deleteCompProduct(ints);
    }

    @Override
    public void saveFile(String filePath, String filename) {

        try {
            File files = new File(filePath);
            FileInputStream fis = new FileInputStream(files);
            byte[] fl = new byte[(int) files.length()];
            fis.read(fl);
            ByteArrayInputStream fileInput = new ByteArrayInputStream(fl);
            compProductMapper.saveFile(fileInput,filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCompProductDoc(CompProduct compProduct) {
        compProduct.setDocId(compProductMapper.getDocId());
        compProductMapper.addCompProductDoc(compProduct);
    }

    @Override
    public void updateCompProductDoc(CompProduct compProduct) {
        compProduct.setDocId(compProductMapper.getDocId());
        compProductMapper.updateCompProductDoc(compProduct);
    }

    @Override
    public Long queryDocByCompProductId(Long compProductId) {
        return compProductMapper.queryDocByCompProductId(compProductId);
    }
}
