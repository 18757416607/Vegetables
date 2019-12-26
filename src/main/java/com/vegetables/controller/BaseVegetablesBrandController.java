package com.vegetables.controller;

import com.vegetables.exception.MyException;
import com.vegetables.pojo.Result;
import com.vegetables.service.BaseVegetablesBrandService;
import com.vegetables.util.JacksonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/15.
 */
@RestController
@RequestMapping(value = "/brand")
public class BaseVegetablesBrandController {


    private Logger logger = Logger.getLogger(BaseVegetablesBrandController.class);
    @Autowired
    private BaseVegetablesBrandService brandService;

    /**
     * 查询蔬菜品牌信息
     * @param paramStr
     *      条件过滤删选
     * @author wqs
     * @return
     *      蔬菜品种信息
     */
    @PostMapping(value = "/getBaseVegetablesBrand")
    public List<Map<String,Object>> getBaseVegetablesBrand(String paramStr) throws Exception{
        logger.info("进入查询蔬菜品牌信息-->controller-->参数:"+paramStr);
        if(paramStr!=null&&!"".equals(paramStr)){
            return brandService.getBaseVegetablesBrand(JacksonUtils.strToMap(paramStr));
        }else{
            List<Map<String,Object>> list = brandService.getBaseVegetablesBrand(null);
            System.out.println(list);
            return list;
        }
    }


    /**
     * 获取蔬菜品牌下拉列表信息
     * @return
     */
    @PostMapping(value = "/getBaseVegetablesBrandCombobox")
    public List<Map<String,Object>> getBaseVegetablesBrandCombobox(){
        return brandService.getBaseVegetablesBrandCombobox();
    }


    /**
     * 添加蔬菜品牌信息
     * @param paramStr
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    @PostMapping(value = "/addBaseVegetablesBrand")
    public Result addBaseVegetablesBrand(String paramStr) throws Exception{
        logger.info("进入添加蔬菜品牌信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);

        if(paramMap.get("add_b_name")==null||"".equals(paramMap.get("add_b_name"))){
            logger.info("添加蔬菜品牌信息-->controller-->[品牌名称]为空");
            throw new MyException("请填写品牌名称","01");
        }
        return brandService.addBaseVegetablesBrand(paramMap);
    }


    /**
     * 修改蔬菜品牌信息
     * @param paramStr
     *      收集蔬菜信息
     * @author wqs
     * @return
     */
    @PostMapping(value = "/updateBaseVegetablesBrand")
    public Result updateBaseVegetablesBrand(String paramStr) throws Exception{
        logger.info("进入修改蔬菜品牌信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("edit_b_name")==null||"".equals(paramMap.get("edit_b_name"))){
            logger.info("修改蔬菜品牌信息-->controller-->[品牌名称]为空");
            throw new MyException("请填写品牌名称","01");
        }
        return brandService.updateBaseVegetablesBrand(paramMap);
    }

    /**
     *  删除蔬菜品牌信息
     * @param paramStr
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/removeBaseVegetablesBrand")
    public Result removeBaseVegetablesBrand(String paramStr) throws Exception{
        logger.info("进入删除蔬菜品牌信息-->controller-->参数:"+paramStr);
        Map<String,Object> paramMap = JacksonUtils.strToMap(paramStr);
        if(paramMap.get("b_id")==null||"".equals(paramMap.get("b_id"))){
            logger.info("删除蔬菜品牌信息-->controller-->[主键ID]为空");
            throw new MyException("蔬菜品牌主编号为空","01");
        }
        paramMap.put("edit_b_del","01");
        return brandService.updateBaseVegetablesBrand(paramMap);
    }


}
