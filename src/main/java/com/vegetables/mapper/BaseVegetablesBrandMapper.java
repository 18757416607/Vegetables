package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/1.
 * 蔬菜品牌
 */
@Mapper
@Repository
public interface BaseVegetablesBrandMapper {


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
    public int addBaseVegetablesBrand(Map<String, Object> param);


    /**
     * 修改蔬菜品牌信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public int updateBaseVegetablesBrand(Map<String, Object> param);




}
