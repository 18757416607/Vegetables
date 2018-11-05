package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/1.
 * 进货来源商户
 */
@Mapper
@Repository
public interface BaseVegetablesPurchaseSourceMerchantMapper {


    /**
     * 查询进货来源商户信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      进货来源商户信息
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSource(Map<String, Object> param);


    /**
     * 添加进货来源商户信息
     * @param param
     *      收集进货来源商户信息
     * @author wqs
     * @return
     */
    public int addBaseVegetablesPurchaseSource(Map<String, Object> param);


    /**
     * 修改进货来源商户信息
     * @param param
     *      收集进货来源商户信息
     * @author wqs
     * @return
     */
    public int updateBaseVegetablesPurchaseSource(Map<String, Object> param);


}
