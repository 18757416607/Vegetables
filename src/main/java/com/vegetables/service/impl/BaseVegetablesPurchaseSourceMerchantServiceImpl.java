package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesPurchaseSourceMerchantMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesPurchaseSourceMerchantService;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/12/4.
 */
@Service
public class BaseVegetablesPurchaseSourceMerchantServiceImpl implements BaseVegetablesPurchaseSourceMerchantService {


    @Autowired
    private BaseVegetablesPurchaseSourceMerchantMapper baseVegetablesPurchaseSourceMerchantMapper;



    /**
     * 查询进货来源商户信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      进货来源商户信息
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceMerchant(Map<String, Object> param){
        if(param!=null){
            if(param.get("m_start_updatetime")!=null&&!"".equals(param.get("m_start_updatetime"))){
                param.put("m_start_updatetime",param.get("m_start_updatetime")+" 00:00:00");
                if(param.get("m_end_updatetime")!=null&&!"".equals(param.get("m_end_updatetime"))){
                    param.put("m_end_updatetime",param.get("m_end_updatetime")+" 23:59:59");
                }
            }
        }
        return baseVegetablesPurchaseSourceMerchantMapper.getBaseVegetablesPurchaseSourceMerchant(param);
    }


    /**
     * 添加进货来源商户信息
     * @param param
     *      收集进货来源商户信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesPurchaseSourceMerchant(Map<String, Object> param) throws Exception{
        if(param.get("add_m_remark")==null||"".equals(param.get("add_m_remark"))){
            param.put("add_m_remark","无");
        }
        int updateCount = baseVegetablesPurchaseSourceMerchantMapper.addBaseVegetablesPurchaseSourceMerchant(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("添加操作成功");
        }
        return ResultUtil.requestSuccess(null,"添加操作受影响0行","02");
    }


    /**
     * 修改进货来源商户信息
     * @param param
     *      收集进货来源商户信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesPurchaseSourceMerchant(Map<String, Object> param) throws Exception{
        int updateCount = baseVegetablesPurchaseSourceMerchantMapper.updateBaseVegetablesPurchaseSourceMerchant(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("修改操作成功");
        }
        return ResultUtil.requestSuccess(null,"修改操作受影响0行","02");
    }


}
