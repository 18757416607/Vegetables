package com.vegetables.service.impl;

import com.vegetables.mapper.BaseVegetablesPurchaseSourceMapper;
import com.vegetables.service.BaseVegetablesPurchaseSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
@Service
public class BaseVegetablesPurchaseSourceServiceImpl implements BaseVegetablesPurchaseSourceService {

    @Autowired
    private BaseVegetablesPurchaseSourceMapper baseVegetablesPurchaseSourceMapper;

    /**
     * 获取进货来源下拉列表数据
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceCombobox(){
        return baseVegetablesPurchaseSourceMapper.getBaseVegetablesPurchaseSourceCombobox();
    }

}
