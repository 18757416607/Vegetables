package com.vegetables.controller;

import com.vegetables.service.BaseVegetablesQuotationService;
import com.vegetables.util.JacksonUtils;
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
        System.out.println(paramStr);
        if(paramStr!=null&&!"".equals(paramStr)){
            return quotationService.getBaseVegetablesQuotation(JacksonUtils.strToMap(paramStr));
        }else{
            return quotationService.getBaseVegetablesQuotation(null);
        }

    }


}
