package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesQuotationMapper;
import com.vegetables.service.BaseVegetablesQuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/5.
 * 蔬菜行情  接口实现类
 */
@Service
public class BaseVegetablesQuotationServiceImpl implements BaseVegetablesQuotationService {

    @Autowired
    private BaseVegetablesQuotationMapper quotationMapper;


    /**
     * 查询蔬菜行情信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜行情信息
     */
    @Override
    public List<Map<String, Object>> getBaseVegetablesQuotation(Map<String, Object> param) {
        return quotationMapper.getBaseVegetablesQuotation(param);
    }


    /**
     * 添加蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    @Override
    public int addBaseVegetablesQuotation(Map<String, Object> param) {
        return 0;
    }



    /**
     * 修改蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    @Override
    public int updateBaseVegetablesQuotation(Map<String, Object> param) {
        return 0;
    }
}
