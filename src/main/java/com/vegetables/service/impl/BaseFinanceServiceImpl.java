package com.vegetables.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vegetables.mapper.BaseFinanceMapper;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseFinanceService;
import com.vegetables.util.DateUtils;
import com.vegetables.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseFinanceServiceImpl implements BaseFinanceService {

    @Autowired
    private BaseFinanceMapper financeMapper;

    Logger logger = Logger.getLogger(BaseFinanceServiceImpl.class);


    /**
     * 查询财务相关信息
     * @param param
     * @return
     */
    public List<Map<String,Object>> getBaseFinance(Map<String,Object> param) throws Exception{
        logger.info("查询财务相关信息service-->参数:"+ JSONObject.toJSONString(param));
        List<Map<String,Object>> financeList = financeMapper.getBaseFinance(param);
        return financeList;
    }

    /**
     * 修改财务相关信息
     * @param param
     * @return
     */
    public Result updateBaseFinance(Map<String,Object> param) throws Exception{
        logger.info("修改财务相关信息service-->参数:"+ JSONObject.toJSONString(param));
        /*String date = param.get("edit_finance_date").toString();
        StringBuilder strDate = new StringBuilder();
        strDate.append(param.get("edit_finance_date")).append(" ").append(DateUtils.getHHMMSS());
        param.put("edit_finance_date",strDate.toString());*/
        int updateCount = financeMapper.updateBaseFinance(param);
        if(updateCount>0){
            return ResultUtil.requestSuccess("","修改成功");
        }
        return ResultUtil.requestSuccess("","修改操作受影响行数0行","01");
    }

    /**
     * 添加财务相关信息
     * @param param
     * @return
     */
    public Result addBaseFinance(Map<String,Object> param) throws Exception{
        logger.info("添加财务相关信息service-->参数:"+ JSONObject.toJSONString(param));
        /*String date = param.get("add_finance_date").toString();
        StringBuilder strDate = new StringBuilder();
        strDate.append(param.get("add_finance_date")).append(" ").append(DateUtils.getHHMMSS());
        param.put("add_finance_date",strDate.toString());*/
        int addCount = financeMapper.addBaseFinance(param);
        if(addCount>0){
            return ResultUtil.requestSuccess("","添加成功");
        }
        return ResultUtil.requestSuccess("","添加操作受影响行数0行","01");
    }


    /**
     * 获取类型信息
     * @return
     */
    public List<Map<String,Object>> getFinanceTypeList(){
        return financeMapper.getFinanceTypeList();
    }

}
