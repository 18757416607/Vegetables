package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/1.
 * 蔬菜类别
 */
@Mapper
@Repository
public interface BaseVegetablesCategoryMapper {


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
     * 获取蔬菜类别下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesCategoryCombobox();


    /**
     * 添加蔬菜类别信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public int addBaseVegetablesCategory(Map<String,Object> param);


    /**
     * 修改蔬菜类别信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public int updateBaseVegetablesCategory(Map<String,Object> param);




}
