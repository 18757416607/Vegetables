package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/1.
 * 蔬菜品种
 */
@Mapper
@Repository
public interface BaseVegetablesVarietiesMapper {

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
     * 添加蔬菜品种信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public int addBaseVegetablesVarieties(Map<String,Object> param);


    /**
     * 修改蔬菜品种信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public int updateBaseVegetablesVarieties(Map<String,Object> param);



}
