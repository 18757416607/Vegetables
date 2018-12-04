package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesPurchaseSourceService;
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
@RequestMapping(value = "/purchaseSource")
public class BaseVegetablesPurchaseSourceController {


    private Logger logger = Logger.getLogger(BaseVegetablesPurchaseSourceController.class);

    @Autowired
    private BaseVegetablesPurchaseSourceService baseVegetablesPurchaseSourceService;


    /**
     * 获取进货来源下拉列表数据
     * @return
     */
    @RequestMapping(value = "/getBaseVegetablesPurchaseSourceCombobox")
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceCombobox(){
        return baseVegetablesPurchaseSourceService.getBaseVegetablesPurchaseSourceCombobox();
    }



    /**
     * 查询进货来源信息
     * @param paramStr
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    @RequestMapping(value = "/getBaseVegetablesPurchaseSource")
    public List<Map<String,Object>> getBaseVegetablesPurchaseSource(String paramStr) throws Exception{
        if(paramStr!=null&&!"".equals(paramStr)){
            return baseVegetablesPurchaseSourceService.getBaseVegetablesPurchaseSource(JacksonUtils.strToMap(paramStr));
        }else{
            return baseVegetablesPurchaseSourceService.getBaseVegetablesPurchaseSource(null);
        }
    }


    /**
     *  添加进货来源信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addBaseVegetablesPurchaseSource")
    public Result addBaseVegetablesPurchaseSource(String paramStr) throws Exception{
        logger.info("进入添加进货来源信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("add_s_name")==null||"".equals(paramMap.get("add_s_name"))){
            logger.info("添加进货来源信息-->controller-->[进货来源名称]为空");
            throw new MyException("请填写进货来源名称","01");
        }
        /*if(paramMap.get("add_s_color")==null||"".equals(paramMap.get("add_s_color"))){
            logger.info("添加进货来源信息-->controller-->[颜色标识]为空");
            throw new MyException("请选择颜色标识","01");
        }*/
        if(paramMap.get("add_s_is_purchase")==null||"".equals(paramMap.get("add_s_is_purchase"))){
            logger.info("添加进货来源信息-->controller-->[是否在此进货]为空");
            throw new MyException("请选择是否在此进货","01");
        }
        return baseVegetablesPurchaseSourceService.addBaseVegetablesPurchaseSource(paramMap);
    }



    /**
     *  修改进货来源信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateBaseVegetablesPurchaseSource")
    public Result updateBaseVegetablesPurchaseSource(String paramStr) throws Exception{
        logger.info("进入修改进货来源信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("edit_s_name")==null||"".equals(paramMap.get("edit_s_name"))){
            logger.info("修改进货来源信息-->controller-->[进货来源名称]为空");
            throw new MyException("请填写进货来源名称","01");
        }
         /*if(paramMap.get("edit_s_color")==null||"".equals(paramMap.get("edit_s_color"))){
            logger.info("修改进货来源信息-->controller-->[颜色标识]为空");
            throw new MyException("请选择颜色标识","01");
        }*/
        if(paramMap.get("edit_s_is_purchase")==null||"".equals(paramMap.get("edit_s_is_purchase"))){
            logger.info("修改进货来源信息-->controller-->[是否在此进货]为空");
            throw new MyException("请选择是否在此进货","01");
        }
        return baseVegetablesPurchaseSourceService.updateBaseVegetablesPurchaseSource(paramMap);
    }



    /**
     *  删除进货来源信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseVegetablesPurchaseSource")
    public Result removeBaseVegetablesPurchaseSource(String paramStr) throws Exception{
        logger.info("进入删除进货来源信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("s_id")==null||"".equals(paramMap.get("s_id"))){
            logger.info("删除进货来源信息-->controller-->[主键ID]为空");
            throw new MyException("进货来源主编号为空","01");
        }
        paramMap.put("edit_s_del","01");
        return baseVegetablesPurchaseSourceService.updateBaseVegetablesPurchaseSource(paramMap);
    }



}
