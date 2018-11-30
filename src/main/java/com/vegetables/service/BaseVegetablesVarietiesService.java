package com.vegetables.service;

import com.vegetables.pojo.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
public interface BaseVegetablesVarietiesService {


    /**
     * 查询蔬菜品种信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    public List<Map<String,Object>> getBaseVegetablesVarieties(Map<String,Object> param);


    /**
     * 获取蔬菜品种下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesVarietiesCombobox();


    /**
     * 添加蔬菜品种信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesVarieties(Map<String,Object> param) throws Exception;


    /**
     * 修改蔬菜品种信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesVarieties(Map<String,Object> param) throws Exception;

}
