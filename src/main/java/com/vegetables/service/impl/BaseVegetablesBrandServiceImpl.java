package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesBrandMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesBrandService;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/15.
 */
@Service
public class BaseVegetablesBrandServiceImpl implements BaseVegetablesBrandService {

    @Autowired
    private BaseVegetablesBrandMapper brandMapper;

    /**
     * 查询蔬菜品牌信息
     * @param param
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    public List<Map<String,Object>> getBaseVegetablesBrand(Map<String, Object> param){
        if(param!=null){
            if(param.get("b_start_updatetime")!=null&&!"".equals(param.get("b_start_updatetime"))){
                param.put("b_start_updatetime",param.get("b_start_updatetime")+" 00:00:00");
                if(param.get("b_end_updatetime")!=null&&!"".equals(param.get("b_end_updatetime"))){
                    param.put("b_end_updatetime",param.get("b_end_updatetime")+" 23:59:59");
                }
            }
        }
        return brandMapper.getBaseVegetablesBrand(param);
    }


    /**
     * 获取蔬菜品牌下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesBrandCombobox(){
        return brandMapper.getBaseVegetablesBrandCombobox();
    }


    /**
     * 添加蔬菜品牌信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result addBaseVegetablesBrand(Map<String, Object> param) throws Exception{
        if(param.get("add_b_remark")==null||"".equals(param.get("add_b_remark"))){
            param.put("add_b_remark","无");
        }
        int updateCount = brandMapper.addBaseVegetablesBrand(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("添加操作成功");
        }
        return ResultUtil.requestSuccess(null,"添加操作受影响0行","02");
    }


    /**
     * 修改蔬菜品牌信息
     * @param param
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    public Result updateBaseVegetablesBrand(Map<String, Object> param) throws Exception{
        int updateCount = brandMapper.updateBaseVegetablesBrand(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("修改操作成功");
        }
        return ResultUtil.requestSuccess(null,"修改操作受影响0行","02");
    }

}
