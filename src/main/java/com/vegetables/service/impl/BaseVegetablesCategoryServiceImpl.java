package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesCategoryMapper;
import com.vegetables.service.BaseVegetablesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/22.
 */
@Service
public class BaseVegetablesCategoryServiceImpl implements BaseVegetablesCategoryService {

    @Autowired
    private BaseVegetablesCategoryMapper categoryMapper;


    /**
     * 获取蔬菜类别下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesCategoryCombobox(){
        return categoryMapper.getBaseVegetablesCategoryCombobox();
    }

}
