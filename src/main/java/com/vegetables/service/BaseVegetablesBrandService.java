package com.vegetables.service;

import com.vegetables.pojo.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/15.
 */
public interface BaseVegetablesBrandService {

    /**
     * 查询蔬菜品牌信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    public List<Map<String,Object>> getBaseVegetablesBrand(Map<String, Object> param);


    /**
     * 获取蔬菜品牌下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesBrandCombobox();


    /**
     * 添加蔬菜品牌信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesBrand(Map<String, Object> param) throws Exception;


    /**
     * 修改蔬菜品牌信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesBrand(Map<String, Object> param) throws Exception;


}
