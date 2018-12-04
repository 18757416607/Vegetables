package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesCategoryMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesCategoryService;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/22.
 */
@Service
public class BaseVegetablesCategoryServiceImpl implements BaseVegetablesCategoryService {

    @Autowired
    private BaseVegetablesCategoryMapper categoryMapper;


    /**
     * 获取蔬菜类别下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesCategoryCombobox(){
        return categoryMapper.getBaseVegetablesCategoryCombobox();
    }



    /**
     * 查询蔬菜类别信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    public List<Map<String,Object>> getBaseVegetablesCategory(Map<String,Object> param){
        return categoryMapper.getBaseVegetablesCategory(param);
    }


    /**
     * 添加蔬菜类别信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesCategory(Map<String,Object> param) throws Exception{

        if(param.get("add_c_remark")==null||"".equals(param.get("add_c_remark"))){
            param.put("add_c_remark","无");
        }
        int updateCount = categoryMapper.addBaseVegetablesCategory(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("添加操作成功");
        }
        return ResultUtil.requestSuccess(null,"添加操作受影响0行","02");

    }


    /**
     * 修改蔬菜类别信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesCategory(Map<String,Object> param) throws Exception{

        int updateCount = categoryMapper.updateBaseVegetablesCategory(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("修改操作成功");
        }
        return ResultUtil.requestSuccess(null,"修改操作受影响0行","02");
    }


}
