package com.vegetables.service;

import com.vegetables.pojo.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/22.
 */
public interface BaseVegetablesCategoryService {

    /**
     * 获取蔬菜类别下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesCategoryCombobox();


    /**
     * 查询蔬菜类别信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    public List<Map<String,Object>> getBaseVegetablesCategory(Map<String,Object> param);


    /**
     * 添加蔬菜类别信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesCategory(Map<String,Object> param) throws Exception;


    /**
     * 修改蔬菜类别信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesCategory(Map<String,Object> param) throws Exception;



}
