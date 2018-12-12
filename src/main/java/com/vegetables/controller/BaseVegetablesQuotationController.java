package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesQuotationService;
import com.vegetables.util.JacksonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/5.
 * 蔬菜行情 controller
 */
@RestController
@RequestMapping(value = "/quotation")
public class BaseVegetablesQuotationController {

    @Autowired
    private BaseVegetablesQuotationService quotationService;

    private Logger logger = Logger.getLogger(BaseVegetablesQuotationController.class);

    /**
     * 查询蔬菜行情信息
     * @param paramStr
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜行情信息
     */
    @PostMapping(value = "/getBaseVegetablesQuotation")
    public List<Map<String,Object>> getBaseVegetablesQuotation(String paramStr) throws IOException {
        logger.info("进入查询蔬菜行情信息-->controller-->参数:"+paramStr);
        if(paramStr!=null&&!"".equals(paramStr)){
            return quotationService.getBaseVegetablesQuotation(JacksonUtils.strToMap(paramStr));
        }else{
            return quotationService.getBaseVegetablesQuotation(null);
        }
    }

    /**
     *  添加蔬菜行情信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addBaseVegetablesQuotation")
    public Result addBaseVegetablesQuotation(String paramStr) throws Exception{
        logger.info("进入添加蔬菜行情信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("add_v_id")==null||"".equals(paramMap.get("add_v_id"))){
            logger.info("添加蔬菜行情信息-->controller-->[蔬菜品种]为空");
            throw new MyException("请选择蔬菜品种","01");
        }
        if(paramMap.get("add_s_id")==null||"".equals(paramMap.get("add_s_id"))){
            logger.info("添加蔬菜行情信息-->controller-->[进货来源]为空");
            throw new MyException("请选择进货来源","01");
        }
        if(paramMap.get("add_q_investigation_date")==null||"".equals(paramMap.get("add_q_investigation_date"))){
            logger.info("添加蔬菜行情信息-->controller-->[调查时间]为空");
            throw new MyException("请填写调查时间","01");
        }
        if(paramMap.get("add_q_investigation_price")==null||"".equals(paramMap.get("add_q_investigation_price"))){
            logger.info("添加蔬菜行情信息-->controller-->[调查价格]为空");
            throw new MyException("请填写调查价格","01");
        }
        if(paramMap.get("add_q_price_increase")==null||"".equals(paramMap.get("add_q_price_increase"))){
            logger.info("添加蔬菜行情信息-->controller-->[价格涨幅]为空");
            throw new MyException("请填写价格涨幅","01");
        }
        /*if(paramMap.get("add_q_del")==null||"".equals(paramMap.get("add_q_del"))){
            logger.info("添加蔬菜行情信息-->controller-->[是否删除]为空");
            throw new MyException("请选择是否删除","01");
        }*/
        return quotationService.addBaseVegetablesQuotation(paramMap);
    }



    /**
     *  修改蔬菜行情信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/editBaseVegetablesQuotation")
    public Result editBaseVegetablesQuotation(String paramStr) throws Exception{
        logger.info("进入修改蔬菜行情信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("edit_s_id")==null||"".equals(paramMap.get("edit_s_id"))){
            logger.info("修改蔬菜行情信息-->controller-->[进货来源]为空");
            throw new MyException("请选择进货来源","01");
        }
        if(paramMap.get("edit_q_investigation_date")==null||"".equals(paramMap.get("edit_q_investigation_date"))){
            logger.info("修改蔬菜行情信息-->controller-->[调查时间]为空");
            throw new MyException("请填写调查时间","01");
        }
        if(paramMap.get("edit_q_investigation_price")==null||"".equals(paramMap.get("edit_q_investigation_price"))){
            logger.info("修改蔬菜行情信息-->controller-->[调查价格]为空");
            throw new MyException("请填写调查价格","01");
        }
        if(paramMap.get("edit_q_price_increase")==null||"".equals(paramMap.get("edit_q_price_increase"))){
            logger.info("修改蔬菜行情信息-->controller-->[价格涨幅]为空");
            throw new MyException("请填写价格涨幅","01");
        }
        /*if(paramMap.get("edit_q_del")==null||"".equals(paramMap.get("edit_q_del"))){
            logger.info("修改蔬菜行情信息-->controller-->[是否删除]为空");
            throw new MyException("请选择是否删除","01");
        }*/
        return quotationService.updateBaseVegetablesQuotation(paramMap);
    }



    /**
     *  删除蔬菜行情信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseVegetablesQuotation")
    public Result removeBaseVegetablesQuotation(String paramStr) throws Exception{
        logger.info("进入删除蔬菜行情信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("q_id")==null||"".equals(paramMap.get("q_id"))){
            logger.info("删除蔬菜行情信息-->controller-->[主键ID]为空");
            throw new MyException("蔬菜行情主编号为空","01");
        }
        paramMap.put("edit_q_del","01");
        return quotationService.updateBaseVegetablesQuotation(paramMap);
    }

}
