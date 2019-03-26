package cc.mrbird.res.service.impl;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.res.dao.AddressMapper;
import cc.mrbird.res.domain.Address;
import cc.mrbird.res.service.AddressService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AddressServiceImpl
 *
 * @author: fengwang
 * @date: 2019-02-22 14:51
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("addressService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AddressServiceImpl extends BaseService<Address> implements AddressService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAll(Address address) {
        try {
            return this.addressMapper.findAll(address);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public JSONObject search(String segmType, String parentSegmId, String segmName) {
        String url = "http://132.225.132.95:8889/ressearch/search.spr?method=getResultJson&sysId=d051f3d2-d332-475a-bed8-e357a306deac&location=&priority=&sort=&isLoginRequest=true";
        String categoryId = "982a05fa-9981-417b-a1ab-3de2e5f27dcd";
        JSONObject msg = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("categoryId", categoryId);
        map.put("resTypeId", 214);
        map.put("keyWord", segmName);
        map.put("begin", 0);
        map.put("count", 10);

        JSONArray condition = new JSONArray();
        if (StringUtils.isNotEmpty(segmType)) {
            JSONObject segmTypeField = new JSONObject();
            segmTypeField.put("fieldName", "segm_type");
            segmTypeField.put("fieldValue", segmType);
            condition.add(segmTypeField);
        }
        if (StringUtils.isNotEmpty(parentSegmId)) {
            JSONObject parentSegmIdField = new JSONObject();
            parentSegmIdField.put("fieldName", "parent_segm_id");
            parentSegmIdField.put("fieldValue", parentSegmId);
            condition.add(parentSegmIdField);
        }
        map.put("condition", condition);

        map.put("location", "");
        map.put("priority", "");
        JSONArray sort = new JSONArray();
        JSONObject standNoField = new JSONObject();
        standNoField.put("fieldName", "stand_no");
        standNoField.put("fieldValue", "asc");
        sort.add(standNoField);
        map.put("sort", sort);
        map.put("isLoginRequest", "true");
        HttpClient client = new HttpClient();
        client.getParams().setContentCharset("UTF-8");
        PostMethod post = new PostMethod(url);
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                post.addParameter(key, MapUtils.getString(map, key));
            }
        }
        try {
            int statusCode = client.executeMethod(post);
            log.info("执行完成，状态码为:" + statusCode);
            String response = post.getResponseBodyAsString();
            log.info("调用结果为:" + response);
            msg = JSONObject.parseObject(response);
            String total = msg.getString("total");
            log.info("total:" + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
