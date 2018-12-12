package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesCategoryService;
import com.vegetables.util.JacksonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/22.
 */
@RestController
@RequestMapping(value = "/category")
public class BaseVegetablesCategoryController {

    private Logger logger = Logger.getLogger(BaseVegetablesCategoryController.class);

    @Autowired
    private BaseVegetablesCategoryService baseVegetablesCategoryService;


    /**
     * 获取蔬菜类别下拉列表信息
     * @return
     */
    @RequestMapping(value = "/getBaseVegetablesCategoryCombobox")
    public List<Map<String,Object>> getBaseVegetablesCategoryCombobox(){
        return baseVegetablesCategoryService.getBaseVegetablesCategoryCombobox();
    }


    /**
     * 查询蔬菜类别信息
     * @param paramStr
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    @RequestMapping(value = "/getBaseVegetablesCategory")
    public List<Map<String,Object>> getBaseVegetablesCategory(String paramStr) throws Exception{
        logger.info("进入查询蔬菜类别信息-->controller-->参数:"+paramStr);
        if(paramStr!=null&&!"".equals(paramStr)){
            return baseVegetablesCategoryService.getBaseVegetablesCategory(JacksonUtils.strToMap(paramStr));
        }else{
            return baseVegetablesCategoryService.getBaseVegetablesCategory(null);
        }
    }


    /**
     * 添加蔬菜类别信息
     * @param paramStr
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    @PostMapping(value = "/addBaseVegetablesCategory")
    public Result addBaseVegetablesCategory(String paramStr) throws Exception{
        logger.info("进入添加蔬菜类别信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);

        if(paramMap.get("add_c_name")==null||"".equals(paramMap.get("add_c_name"))){
            logger.info("添加蔬菜类别信息-->controller-->[类别名称]为空");
            throw new MyException("请填写类别名称","01");
        }
        return baseVegetablesCategoryService.addBaseVegetablesCategory(paramMap);
    }


    /**
     * 修改蔬菜类别信息
     * @param paramStr
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    @PostMapping(value = "/updateBaseVegetablesCategory")
    public Result updateBaseVegetablesCategory(String paramStr) throws Exception{
        logger.info("进入蔬菜类别信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("edit_c_name")==null||"".equals(paramMap.get("edit_c_name"))){
            logger.info("修改蔬菜类别信息-->controller-->[种类名称]为空");
            throw new MyException("请填写种类名称","01");
        }
        return baseVegetablesCategoryService.updateBaseVegetablesCategory(paramMap);
    }



    /**
     *  删除蔬菜类别信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseVegetablesCategory")
    public Result removeBaseVegetablesCategory(String paramStr) throws Exception{
        logger.info("进入删除蔬菜类别信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("c_id")==null||"".equals(paramMap.get("c_id"))){
            logger.info("删除蔬菜类别信息-->controller-->[主键ID]为空");
            throw new MyException("蔬菜类别主编号为空","01");
        }
        paramMap.put("edit_c_del","01");
        return baseVegetablesCategoryService.updateBaseVegetablesCategory(paramMap);
    }




}
