package com.wharf.dao;

import com.wharf.pojo.BaseUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/23.
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 根据userName查询user信息
     * @param username
     * @return
     */
    public BaseUser getUserByUserName(String username);

    /**
     * 上传图片时把路劲保存到数据库
     * @param param
     * @return
     */
    public int insertBaseResource(Map<String,Object> param);

    /**
     * 获取上传图片信息
     * @param param
     * @return
     */
    public List<Map<String,Object>> getBaseResource(Map<String,Object> param);

    /**
     * 获取一个上传图片详细信息
     * @param id
     * @return
     */
    public Map<String,Object> getOneBaseResourceDetail(String id);


    /**
     * 按日期的年月日进行分组  获取指定时间内的每天有多少条数据
     * @param param
     * @return
     */
    public List<Map<String,Object>> getGorupDateRows(Map<String,Object> param);

    /**
     * 获取白名单列表
     * @return
     */
    public List<Map<String,Object>> getWhiteList();

    /**
     * 修改白名单信息
     * @return
     */
    public int updateWhite(Map<String,Object> param);

    /**
     * 删除白名单信息
     * @return
     */
    public int deleteWhite(String id);

    /**
     * 根据车牌号查看白名单信息
     * @param platenum
     * @return
     */
    public Map<String,Object> getWhiteByPlateNum(String platenum);

    /**
     * 批量加入白名单信息
     * @param param
     * @return
     */
    public int insertBatchWhite(List<Map<String,Object>> param);

}
