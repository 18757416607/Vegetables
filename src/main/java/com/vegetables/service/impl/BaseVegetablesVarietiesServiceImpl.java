package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesVarietiesMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesVarietiesService;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
@Service
public class BaseVegetablesVarietiesServiceImpl implements BaseVegetablesVarietiesService {

    @Autowired
    private BaseVegetablesVarietiesMapper baseVegetablesVarietiesMapper;


    /**
     * 查询蔬菜品种信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    public List<Map<String,Object>> getBaseVegetablesVarieties(Map<String,Object> param){
        if(param!=null){
            if(param.get("v_start_updatetime")!=null&&!"".equals(param.get("v_start_updatetime"))){
                param.put("v_start_updatetime",param.get("v_start_updatetime")+" 00:00:00");
                if(param.get("v_end_updatetime")!=null&&!"".equals(param.get("v_end_updatetime"))){
                    param.put("v_end_updatetime",param.get("v_end_updatetime")+" 23:59:59");
                }
            }
        }
        return baseVegetablesVarietiesMapper.getBaseVegetablesVarieties(param);
    }



    /**
     * 获取蔬菜品种下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesVarietiesCombobox(){
        return baseVegetablesVarietiesMapper.getBaseVegetablesVarietiesCombobox();
    }

    /**
     * 添加蔬菜品种信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    @Override
    public Result addBaseVegetablesVarieties(Map<String, Object> param) throws Exception{
        if(param.get("add_v_remark")==null||"".equals(param.get("add_v_remark"))){
            param.put("add_v_remark","无");
        }
        int updateCount = baseVegetablesVarietiesMapper.addBaseVegetablesVarieties(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("添加操作成功");
        }
        return ResultUtil.requestSuccess(null,"添加操作受影响0行","02");
    }



    /**
     * 修改蔬菜品种信息
     * @param param
     *      收集蔬菜行情信息
     * @author wqs
     * @return
     */
    @Override
    public Result updateBaseVegetablesVarieties(Map<String, Object> param) throws Exception{
        int updateCount = baseVegetablesVarietiesMapper.updateBaseVegetablesVarieties(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("修改操作成功");
        }
        return ResultUtil.requestSuccess(null,"修改操作受影响0行","02");
    }



}
