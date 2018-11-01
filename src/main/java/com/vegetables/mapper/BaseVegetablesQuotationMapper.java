package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/1.
 * 蔬菜行情
 */
@Mapper
@Repository
public interface BaseVegetablesQuotationMapper {

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
    public int addBaseVegetablesQuotation(Map<String,Object> param);


    /**
     * 修改蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    public int updateBaseVegetablesQuotation(Map<String,Object> param);




}
