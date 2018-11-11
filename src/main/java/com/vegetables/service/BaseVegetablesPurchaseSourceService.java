package com.vegetables.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
public interface BaseVegetablesPurchaseSourceService {

    /**
     * 获取进货来源下拉列表数据
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesPurchaseSourceCombobox();

}
