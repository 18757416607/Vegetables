package com.vegetables.service;

import com.vegetables.pojo.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/12/4.
 */
public interface BaseVegetablesPurchaseSourceMerchantService {

    /**
     * 查询进货来源商户信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      进货来源商户信息
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceMerchant(Map<String, Object> param);


    /**
     * 获取进货来源商户下拉列表数据
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceMerchantCombobox();


    /**
     * 添加进货来源商户信息
     * @param param
     *      收集进货来源商户信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesPurchaseSourceMerchant(Map<String, Object> param) throws Exception;


    /**
     * 修改进货来源商户信息
     * @param param
     *      收集进货来源商户信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesPurchaseSourceMerchant(Map<String, Object> param) throws Exception;


}
