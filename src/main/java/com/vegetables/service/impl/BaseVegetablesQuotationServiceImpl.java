package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesQuotationMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesQuotationService;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/5.
 * 蔬菜行情  接口实现类
 */
@Service
public class BaseVegetablesQuotationServiceImpl implements BaseVegetablesQuotationService {

    @Autowired
    private BaseVegetablesQuotationMapper quotationMapper;


    /**
     * 查询蔬菜行情信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜行情信息
     */
    @Override
    public List<Map<String, Object>> getBaseVegetablesQuotation(Map<String, Object> param) {
        return quotationMapper.getBaseVegetablesQuotation(param);
    }



    /**
     * 添加蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    @Override
    public Result addBaseVegetablesQuotation(Map<String, Object> param) throws Exception{
        if(param.get("add_q_remark")==null||"".equals(param.get("add_q_remark"))){
            param.put("add_q_remark","无");
        }
        int updateCount = quotationMapper.addBaseVegetablesQuotation(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("添加操作成功");
        }
        return ResultUtil.requestSuccess(null,"添加操作受影响0行","02");
    }



    /**
     * 修改蔬菜行情信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    @Override
    public Result updateBaseVegetablesQuotation(Map<String, Object> param) throws Exception{
        int updateCount = quotationMapper.updateBaseVegetablesQuotation(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("修改操作成功");
        }
        return ResultUtil.requestSuccess(null,"修改操作受影响0行","02");
    }
}
