package com.vegetables.controller;

import com.vegetables.service.BaseVegetablesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
