package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.BaseUser;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseFinanceService;
import com.vegetables.util.DateUtils;
import com.vegetables.util.DownLoadExcelUtils;
import com.vegetables.util.JacksonUtils;
import com.vegetables.util.PathUtil;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;

@RequestMapping(value = "/finance")
@RestController
public class BaseFinanceController {

    @Autowired
    private BaseFinanceService baseFinanceService;

    private Logger logger = Logger.getLogger(BaseFinanceController.class);

    /**
     * 查询财务相关信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getBaseFinance")
    public List<Map<String,Object>> getBaseFinance(String paramStr) throws Exception{
        logger.info("进入查询财务相关信息-->controller-->参数:"+paramStr);
        if(paramStr!=null&&!"".equals(paramStr)){
            return baseFinanceService.getBaseFinance(JacksonUtils.strToMap(paramStr));
        }else{
            List<Map<String,Object>> list = baseFinanceService.getBaseFinance(null);
            System.out.println(list);
            return list;
        }
    }


    /**
     * 获取类型信息
     * @return
     */
    @PostMapping(value = "/getFinanceTypeList")
    public List<Map<String,Object>> getFinanceTypeList(){
        return baseFinanceService.getFinanceTypeList();
    }



    /**
     * 添加财务信息
     * @param paramStr
     * @author wqs
     * @return
     */
    @PostMapping(value = "/addBaseFinance")
    public Result addBaseFinance(String paramStr, HttpSession session) throws Exception{
        logger.info("进入添加财务信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        BaseUser baseUser = (BaseUser)session.getAttribute("userinfo");
        paramMap.put("add_user_id",baseUser.getUsername());
        return baseFinanceService.addBaseFinance(paramMap);
    }


    /**
     * 修改财务信息
     * @param paramStr
     * @author wqs
     * @return
     */
    @PostMapping(value = "/updateBaseFinance")
    public Result updateBaseFinance(String paramStr) throws Exception{
        logger.info("进入修改财务信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        return baseFinanceService.updateBaseFinance(paramMap);
    }

    /**
     *  删除财务信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseFinance")
    public Result removeBaseFinance(String paramStr) throws Exception{
        logger.info("进入删除财务信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        paramMap.put("edit_finance_is_del","01");
        return baseFinanceService.updateBaseFinance(paramMap);
    }


    /**
     * 下载当前列表Excel
     * @return
     */
    @GetMapping(value = "/downloadCurrFinanceExcel")
    public void downloadCurrFinanceExcel(String paramStr, HttpServletResponse response) throws Exception{
        paramStr = URLDecoder.decode(paramStr, "UTF-8");
        logger.info("进入下载当前列表Excel-->controller-->参数:"+paramStr);
        List<Map<String,Object>> list = null;
        if(paramStr!=null&&!"".equals(paramStr)){
            list = baseFinanceService.getBaseFinance(JacksonUtils.strToMap(paramStr));
        }else{
            list = baseFinanceService.getBaseFinance(null);
        }
        DownLoadExcelUtils.downFinanceExcel(list,response,DateUtils.format(new Date()));
    }

    /**
     * 下载近七日数据Excel
     * @return
     */
    @GetMapping(value = "/downloadWeekFinanceExcel")
    public void downloadWeekFinanceExcel(HttpServletResponse response) throws Exception{
        logger.info("进入下载近七日数据Excel-->controller");
        Map<String,Object> paramJson = new HashMap<>();
        String start_create_time = DateUtils.format(DateUtils.format(DateUtils.formatDateToStr(DateUtils.addOneDay(new Date(),-7))));
        String end_create_time = DateUtils.format(DateUtils.format(DateUtils.getCurrDateTimeStr()));
        paramJson.put("start_create_time",start_create_time +" 00:00:00");
        paramJson.put("end_create_time",end_create_time + " 23:59:59");
        List<Map<String,Object>> list = baseFinanceService.getBaseFinance(paramJson);
        String fileNameDate = start_create_time  +"至"+ end_create_time;
        DownLoadExcelUtils.downFinanceExcel(list,response,fileNameDate);
    }


    /**
     * 下载当月数据到Excel
     * @return
     */
    @GetMapping(value = "/downloadMonthsFinanceExcel")
    public void downloadMonthsFinanceExcel(String paramStr, HttpServletResponse response) throws Exception{
        logger.info("进入下载当月数据到Excel-->controller");
        Map<String,Object> paramJson = paramJson = new HashMap<>();
        Map<String,Integer> dateMap = DateUtils.getSplitDate();
        paramJson.put("month",dateMap.get("month"));
        List<Map<String,Object>> list = baseFinanceService.getBaseFinance(paramJson);
        DownLoadExcelUtils.downFinanceExcel(list,response,dateMap.get("year")+"年"+dateMap.get("month")+"月");
    }

    /**
     * 下载本季度数据到Excel
     * @return
     */
    @GetMapping(value = "/downloadQuarterFinanceExcel")
    public void downloadQuarterFinanceExcel(String paramStr, HttpServletResponse response) throws Exception{
        logger.info("进入下载本季度数据到Excel-->controller");
        Map<String,Object> paramJson = paramJson = new HashMap<>();
        Map<String,Integer> dateMap = DateUtils.getSplitDate();
        int curr_month = dateMap.get("month");
        String curr_year = dateMap.get("year").toString();
        String start_create_time = null;
        String end_create_time = null;
        String monthScopeName = null;
        if(curr_month<=3){
            monthScopeName = "1-3";
            start_create_time = curr_year + "-1-1";
            end_create_time = curr_year + "-3-31";
        }else if(curr_month>=4 && curr_month <=6){
            monthScopeName = "4-6";
            start_create_time = curr_year + "-4-1";
            end_create_time = curr_year + "-6-31";
        }else if(curr_month>=7 && curr_month <=9){
            monthScopeName = "7-9";
            start_create_time = curr_year + "-7-1";
            end_create_time = curr_year + "-9-31";
        }else if(curr_month>=10 && curr_month <=12){
            monthScopeName = "10-12";
            start_create_time = curr_year + "-10-1";
            end_create_time = curr_year + "-12-31";
        }

        paramJson.put("start_create_time",start_create_time +" 00:00:00");
        paramJson.put("end_create_time",end_create_time + " 23:59:59");

        List<Map<String,Object>> list = baseFinanceService.getBaseFinance(paramJson);
        DownLoadExcelUtils.downFinanceExcel(list,response,dateMap.get("year")+"年"+monthScopeName+"月");
    }

    /**
     * 下载今年数据到Excel
     * @return
     */
    @GetMapping(value = "/downloadYearFinanceExcel")
    public void downloadYearFinanceExcel(String paramStr, HttpServletResponse response) throws Exception{
        logger.info("进入下载今年数据到Excel-->controller");
        Map<String,Object> paramJson = paramJson = new HashMap<>();
        Map<String,Integer> dateMap = DateUtils.getSplitDate();
        paramJson.put("year",dateMap.get("year"));
        List<Map<String,Object>> list = baseFinanceService.getBaseFinance(paramJson);
        DownLoadExcelUtils.downFinanceExcel(list,response,dateMap.get("year")+"年");
    }



}
