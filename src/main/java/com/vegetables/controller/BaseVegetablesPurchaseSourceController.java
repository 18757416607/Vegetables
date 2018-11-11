package com.vegetables.controller;

import com.vegetables.service.BaseVegetablesPurchaseSourceService;
import org.springframework.beans.factory.annotation.Autowired;
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



}
