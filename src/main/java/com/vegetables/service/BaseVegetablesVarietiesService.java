package com.vegetables.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/11.
 */
public interface BaseVegetablesVarietiesService {


    /**
     * 获取蔬菜品种下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesVarietiesCombobox();

}
