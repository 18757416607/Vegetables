package com.vegetables.service;

import com.vegetables.pojo.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/5.
 * 蔬菜行情  接口类
 */
public interface BaseVegetablesQuotationService {


    /**
     * 查询蔬菜行情信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜行情信息
     */
    public List<Map<String,Object>> getBaseVegetablesQuotation(Map<String,Object> param);


    /**
     * 添加蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesQuotation(Map<String,Object> param) throws Exception;


    /**
     * 修改蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesQuotation(Map<String,Object> param) throws Exception;


}
