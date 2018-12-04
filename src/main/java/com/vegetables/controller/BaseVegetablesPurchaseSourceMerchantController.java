package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesPurchaseSourceMerchantService;
import com.vegetables.util.JacksonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/12/4.
 */
@RestController
@RequestMapping(value = "/purchaseSourceMerchant")
public class BaseVegetablesPurchaseSourceMerchantController {


    private Logger logger = Logger.getLogger(BaseVegetablesPurchaseSourceMerchantController.class);

    @Autowired
    private BaseVegetablesPurchaseSourceMerchantService baseVegetablesPurchaseSourceMerchantService;


    /**
     * 查询进货来源商户信息
     * @param paramStr
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    @RequestMapping(value = "/getBaseVegetablesPurchaseSourceMerchant")
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceMerchant(String paramStr) throws Exception{
        if(paramStr!=null&&!"".equals(paramStr)){
            return baseVegetablesPurchaseSourceMerchantService.getBaseVegetablesPurchaseSourceMerchant(JacksonUtils.strToMap(paramStr));
        }else{
            return baseVegetablesPurchaseSourceMerchantService.getBaseVegetablesPurchaseSourceMerchant(null);
        }
    }



    /**
     *  添加进货来源商户信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addBaseVegetablesPurchaseSourceMerchant")
    public Result addBaseVegetablesPurchaseSourceMerchant(String paramStr) throws Exception{
        logger.info("进入添加进货来源商户信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("add_s_id")==null||"".equals(paramMap.get("add_s_id"))){
            logger.info("添加进货来源商户信息-->controller-->[进货来源]为空");
            throw new MyException("请选择进货来源","01");
        }
        if(paramMap.get("add_m_name")==null||"".equals(paramMap.get("add_m_name"))){
            logger.info("添加进货来源商户信息-->controller-->[商户店铺名称]为空");
            throw new MyException("请填写商户店铺名称","01");
        }
        if(paramMap.get("add_m_gender")==null||"".equals(paramMap.get("add_m_gender"))){
            logger.info("添加进货来源商户信息-->controller-->[性别]为空");
            throw new MyException("请选择性别","01");
        }
        if(paramMap.get("add_m_boss_name")==null||"".equals(paramMap.get("add_m_boss_name"))){
            logger.info("添加进货来源商户信息-->controller-->[商户老板名字]为空");
            throw new MyException("请填写商户老板名字","01");
        }
        if(paramMap.get("add_m_boss_phone")==null||"".equals(paramMap.get("add_m_boss_phone"))){
            logger.info("添加进货来源商户信息-->controller-->[商户老板手机号]为空");
            throw new MyException("请填写商户老板手机号","01");
        }
        if(paramMap.get("add_m_is_cooperation")==null||"".equals(paramMap.get("add_m_is_cooperation"))){
            logger.info("添加进货来源商户信息-->controller-->[是否合作]为空");
            throw new MyException("请选择是否合作","01");
        }
        return baseVegetablesPurchaseSourceMerchantService.addBaseVegetablesPurchaseSourceMerchant(paramMap);
    }



    /**
     *  修改进货来源商户信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateBaseVegetablesPurchaseSourceMerchant")
    public Result updateBaseVegetablesPurchaseSourceMerchant(String paramStr) throws Exception{
        logger.info("进入修改进货来源商户信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("edit_s_id")==null||"".equals(paramMap.get("edit_s_id"))){
            logger.info("修改进货来源商户信息-->controller-->[进货来源]为空");
            throw new MyException("请选择进货来源","01");
        }
        if(paramMap.get("edit_m_name")==null||"".equals(paramMap.get("edit_m_name"))){
            logger.info("修改进货来源商户信息-->controller-->[商户店铺名称]为空");
            throw new MyException("请填写商户店铺名称","01");
        }
        if(paramMap.get("edit_m_gender")==null||"".equals(paramMap.get("edit_m_gender"))){
            logger.info("修改进货来源商户信息-->controller-->[性别]为空");
            throw new MyException("请选择性别","01");
        }
        if(paramMap.get("edit_m_boss_name")==null||"".equals(paramMap.get("edit_m_boss_name"))){
            logger.info("修改进货来源商户信息-->controller-->[商户老板名字]为空");
            throw new MyException("请填写商户老板名字","01");
        }
        if(paramMap.get("edit_m_boss_phone")==null||"".equals(paramMap.get("edit_m_boss_phone"))){
            logger.info("修改进货来源商户信息-->controller-->[商户老板手机号]为空");
            throw new MyException("请填写商户老板手机号","01");
        }
        if(paramMap.get("edit_m_is_cooperation")==null||"".equals(paramMap.get("edit_m_is_cooperation"))){
            logger.info("修改进货来源商户信息-->controller-->[是否合作]为空");
            throw new MyException("请选择是否合作","01");
        }
        return baseVegetablesPurchaseSourceMerchantService.updateBaseVegetablesPurchaseSourceMerchant(paramMap);
    }



    /**
     *  删除进货来源商户信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseVegetablesPurchaseSourceMerchant")
    public Result removeBaseVegetablesPurchaseSourceMerchant(String paramStr) throws Exception{
        logger.info("进入删除进货来源商户信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("m_id")==null||"".equals(paramMap.get("m_id"))){
            logger.info("删除进货来源商户信息-->controller-->[主键ID]为空");
            throw new MyException("进货来源商户主编号为空","01");
        }
        paramMap.put("edit_m_del","01");
        return baseVegetablesPurchaseSourceMerchantService.updateBaseVegetablesPurchaseSourceMerchant(paramMap);
    }


}
