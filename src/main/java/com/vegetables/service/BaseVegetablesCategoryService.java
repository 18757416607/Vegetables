package com.vegetables.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Mloong on 2018/11/22.
 */
public interface BaseVegetablesCategoryService {

    /**
     * 获取蔬菜类别下拉列表信息
     * @return
     */
    public List<Map<String,Object>> getBaseVegetablesCategoryCombobox();


}
