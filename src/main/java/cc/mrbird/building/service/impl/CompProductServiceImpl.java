package cc.mrbird.building.service.impl;

import cc.mrbird.building.dao.CompProductMapper;
import cc.mrbird.building.domain.CompProduct;
import cc.mrbird.building.service.CompProductService;
import cc.mrbird.common.util.Constant;
import cc.mrbird.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fang.yefei.
 * Date: 2019/2 /28
 * Features:
 */
@Service("compProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
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
            fis.read(fl);//页面显示出图片
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
    //查看是否存在竞争产品与附件关系
    public Long queryDocByCompProductId(Long compProductId) {
        return compProductMapper.queryDocByCompProductId(compProductId);
    }

    @Override
    //查看附件内容
    public CompProduct queryDocById(Long docId) {
        return compProductMapper.queryDocById(docId);
    }
}
