package com.vegetables.service;

import com.vegetables.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface BaseFinanceService {

    /**
     * 查询财务相关信息
     * @param param
     * @return
     */
    public List<Map<String,Object>> getBaseFinance(Map<String,Object> param) throws Exception;

    /**
     * 修改财务相关信息
     * @param param
     * @return
     */
    public Result updateBaseFinance(Map<String,Object> param) throws Exception;

    /**
     * 添加财务相关信息
     * @param param
     * @return
     */
    public Result addBaseFinance(Map<String,Object> param) throws Exception;


    /**
     * 获取类型信息
     * @return
     */
    public List<Map<String,Object>> getFinanceTypeList();

}
