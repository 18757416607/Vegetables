package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesVarietiesService;
import com.vegetables.util.JacksonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
@RestController
@RequestMapping(value = "/varieties")
public class BaseVegetablesVarietiesController{


    private Logger logger = Logger.getLogger(BaseVegetablesVarietiesController.class);

    @Autowired
    private BaseVegetablesVarietiesService baseVegetablesVarietiesService;

    /**
     * 查询蔬菜品种信息
     * @param paramStr
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    @RequestMapping(value = "/getBaseVegetablesVarieties")
    public List<Map<String,Object>> getBaseVegetablesVarieties(String paramStr) throws Exception{
        logger.info("进入查询蔬菜品种信息-->controller-->参数:"+paramStr);
        if(paramStr!=null&&!"".equals(paramStr)){
            return baseVegetablesVarietiesService.getBaseVegetablesVarieties(JacksonUtils.strToMap(paramStr));
        }else{
            return baseVegetablesVarietiesService.getBaseVegetablesVarieties(null);
        }
    }


    /**
     * 获取蔬菜品种下拉列表信息
     * @return
     */
    @RequestMapping(value = "/getVarietiesCombobox")
    public List<Map<String,Object>> getVarietiesCombobox(){
        return baseVegetablesVarietiesService.getBaseVegetablesVarietiesCombobox();
    }


    /**
     *  添加蔬菜品种信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addBaseVegetablesVarieties")
    public Result addBaseVegetablesVarieties(String paramStr) throws Exception{
        logger.info("进入添加蔬菜品种信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("add_c_id")==null||"".equals(paramMap.get("add_c_id"))){
            logger.info("添加蔬菜品种信息-->controller-->[蔬菜类别]为空");
            throw new MyException("请选择蔬菜类别","01");
        }
        if(paramMap.get("add_s_id")==null||"".equals(paramMap.get("add_s_id"))){
            logger.info("添加蔬菜品种信息-->controller-->[进货来源]为空");
            throw new MyException("请选择进货来源","01");
        }
        if(paramMap.get("add_v_price")==null||"".equals(paramMap.get("add_v_price"))){
            logger.info("添加蔬菜品种信息-->controller-->[蔬菜价格]为空");
            throw new MyException("请填写蔬菜价格","01");
        }
        if(paramMap.get("add_v_mature_season")==null||"".equals(paramMap.get("add_v_mature_season"))){
            logger.info("添加蔬菜品种信息-->controller-->[蔬菜上市季节]为空");
            throw new MyException("请填写蔬菜上市季节","01");
        }
        if(paramMap.get("add_v_mature_end_season")==null||"".equals(paramMap.get("add_v_mature_end_season"))){
            logger.info("添加蔬菜品种信息-->controller-->[蔬菜下市季节]为空");
            throw new MyException("请填写蔬菜下市季节","01");
        }
        if(paramMap.get("add_v_is_back_season")==null||"".equals(paramMap.get("add_v_is_back_season"))){
            logger.info("添加蔬菜品种信息-->controller-->[是否反季节]为空");
            throw new MyException("请选择是否反季节","01");
        }
        /*if(paramMap.get("add_v_del")==null||"".equals(paramMap.get("add_v_del"))){
            logger.info("添加蔬菜品种信息-->controller-->[是否删除]为空");
            throw new MyException("请选择是否删除","01");
        }*/
        return baseVegetablesVarietiesService.addBaseVegetablesVarieties(paramMap);
    }



    /**
     *  修改蔬菜品种信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/editBaseVegetablesVarieties")
    public Result editBaseVegetablesVarieties(String paramStr) throws Exception{
        logger.info("进入修改蔬菜品种信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("edit_c_id")==null||"".equals(paramMap.get("edit_c_id"))){
            logger.info("修改蔬菜品种信息-->controller-->[蔬菜类别]为空");
            throw new MyException("请选择蔬菜类别","01");
        }
        if(paramMap.get("edit_s_id")==null||"".equals(paramMap.get("edit_s_id"))){
            logger.info("修改蔬菜品种信息-->controller-->[进货来源]为空");
            throw new MyException("请选择进货来源","01");
        }
        if(paramMap.get("edit_v_price")==null||"".equals(paramMap.get("edit_v_price"))){
            logger.info("修改蔬菜品种信息-->controller-->[蔬菜价格]为空");
            throw new MyException("请填写蔬菜价格","01");
        }
        if(paramMap.get("edit_v_mature_season")==null||"".equals(paramMap.get("edit_v_mature_season"))){
            logger.info("修改蔬菜品种信息-->controller-->[蔬菜上市季节]为空");
            throw new MyException("请填写蔬菜上市季节","01");
        }
        if(paramMap.get("edit_v_mature_end_season")==null||"".equals(paramMap.get("edit_v_mature_end_season"))){
            logger.info("修改蔬菜品种信息-->controller-->[蔬菜下市季节]为空");
            throw new MyException("请填写蔬菜下市季节","01");
        }
        if(paramMap.get("edit_v_is_back_season")==null||"".equals(paramMap.get("edit_v_is_back_season"))){
            logger.info("修改蔬菜品种信息-->controller-->[是否反季节]为空");
            throw new MyException("请选择是否反季节","01");
        }
        /*if(paramMap.get("edit_v_del")==null||"".equals(paramMap.get("edit_v_del"))){
            logger.info("添加蔬菜品种信息-->controller-->[是否删除]为空");
            throw new MyException("请选择是否删除","01");
        }*/
        return baseVegetablesVarietiesService.updateBaseVegetablesVarieties(paramMap);
    }



    /**
     *  删除蔬菜品种信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseVegetablesVarieties")
    public Result removeBaseVegetablesVarieties(String paramStr) throws Exception{
        logger.info("进入删除蔬菜品种信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("v_id")==null||"".equals(paramMap.get("v_id"))){
            logger.info("删除蔬菜品种信息-->controller-->[主键ID]为空");
            throw new MyException("蔬菜品种主编号为空","01");
        }
        paramMap.put("edit_v_del","01");
        return baseVegetablesVarietiesService.updateBaseVegetablesVarieties(paramMap);
    }



}
