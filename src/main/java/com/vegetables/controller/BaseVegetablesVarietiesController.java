package com.vegetables.controller;

import com.vegetables.service.BaseVegetablesVarietiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
@RestController
@RequestMapping(value = "/varieties")
public class BaseVegetablesVarietiesController {


    @Autowired
    private BaseVegetablesVarietiesService baseVegetablesVarietiesService;

    /**
     * 获取蔬菜品种下拉列表信息
     * @return
     */
    @RequestMapping(value = "/getVarietiesCombobox")
    public List<Map<String,Object>> getVarietiesCombobox(){
        return baseVegetablesVarietiesService.getBaseVegetablesVarietiesCombobox();
    }


}
