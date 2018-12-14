package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesPurchaseSourceMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesPurchaseSourceService;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
@Service
public class BaseVegetablesPurchaseSourceServiceImpl implements BaseVegetablesPurchaseSourceService {

    @Autowired
    private BaseVegetablesPurchaseSourceMapper baseVegetablesPurchaseSourceMapper;

    /**
     * 获取进货来源下拉列表数据
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceCombobox(){
        return baseVegetablesPurchaseSourceMapper.getBaseVegetablesPurchaseSourceCombobox();
    }


    /**
     * 查询蔬菜进货来源信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜蔬菜进货来源信息
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSource(Map<String,Object> param){
        if(param!=null){
            if(param.get("s_start_updatetime")!=null&&!"".equals(param.get("s_start_updatetime"))){
                param.put("s_start_updatetime",param.get("s_start_updatetime")+" 00:00:00");
                if(param.get("s_end_updatetime")!=null&&!"".equals(param.get("s_end_updatetime"))){
                    param.put("s_end_updatetime",param.get("s_end_updatetime")+" 23:59:59");
                }
            }
        }
        return baseVegetablesPurchaseSourceMapper.getBaseVegetablesPurchaseSource(param);
    }


    /**
     * 添加蔬菜进货来源信息
     * @param param
     *      收集蔬菜进货来源信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesPurchaseSource(Map<String,Object> param) throws Exception{
        if(param.get("add_s_remark")==null||"".equals(param.get("add_s_remark"))){
            param.put("add_s_remark","无");
        }
        int updateCount = baseVegetablesPurchaseSourceMapper.addBaseVegetablesPurchaseSource(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("添加操作成功");
        }
        return ResultUtil.requestSuccess(null,"添加操作受影响0行","02");
    }


    /**
     * 修改蔬菜进货来源信息
     * @param param
     *      收集蔬菜进货来源信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesPurchaseSource(Map<String,Object> param) throws Exception{
        int updateCount = baseVegetablesPurchaseSourceMapper.updateBaseVegetablesPurchaseSource(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("修改操作成功");
        }
        return ResultUtil.requestSuccess(null,"修改操作受影响0行","02");
    }


}
