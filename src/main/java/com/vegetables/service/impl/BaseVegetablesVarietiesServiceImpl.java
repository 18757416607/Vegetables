package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesVarietiesMapper;
import com.vegetables.service.BaseVegetablesVarietiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
@Service
public class BaseVegetablesVarietiesServiceImpl implements BaseVegetablesVarietiesService {

    @Autowired
    private BaseVegetablesVarietiesMapper baseVegetablesVarietiesMapper;

    /**
     * 获取蔬菜品种下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesVarietiesCombobox(){
        return baseVegetablesVarietiesMapper.getBaseVegetablesVarietiesCombobox();
    }


}
