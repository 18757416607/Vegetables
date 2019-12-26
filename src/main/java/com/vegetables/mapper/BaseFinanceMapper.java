package com.vegetables.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BaseFinanceMapper {

    /**
     * 查询财务相关信息
     * @param param
     * @return
     */
    public List<Map<String,Object>> getBaseFinance(Map<String,Object> param);

    /**
     * 修改财务相关信息
     * @param param
     * @return
     */
    public int updateBaseFinance(Map<String,Object> param);

    /**
     * 添加财务相关信息
     * @param param
     * @return
     */
    public int addBaseFinance(Map<String,Object> param);

    /**
     * 获取类型信息
     * @return
     */
    public List<Map<String,Object>> getFinanceTypeList();
}
