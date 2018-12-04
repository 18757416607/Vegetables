package com.vegetables.service;

import com.vegetables.pojo.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
public interface BaseVegetablesPurchaseSourceService {

    /**
     * 获取进货来源下拉列表数据
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceCombobox();


    /**
     * 查询蔬菜进货来源信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜蔬菜进货来源信息
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSource(Map<String,Object> param);


    /**
     * 添加蔬菜进货来源信息
     * @param param
     *      收集蔬菜进货来源信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesPurchaseSource(Map<String,Object> param) throws Exception;


    /**
     * 修改蔬菜进货来源信息
     * @param param
     *      收集蔬菜进货来源信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesPurchaseSource(Map<String,Object> param) throws Exception;




}
