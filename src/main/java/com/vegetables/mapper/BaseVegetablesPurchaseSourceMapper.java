package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/1.
 * 蔬菜进货来源
 */
@Mapper
@Repository
public interface BaseVegetablesPurchaseSourceMapper {


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
    public int addBaseVegetablesPurchaseSource(Map<String,Object> param);


    /**
     * 修改蔬菜进货来源信息
     * @param param
     *      收集蔬菜进货来源信息
     * @author wqs
     * @return
     */
    public int updateBaseVegetablesPurchaseSource(Map<String,Object> param);


}
