package com.vegetables.service;

import com.alibaba.fastjson.JSONObject;
import com.vegetables.dao.UserMapper;
import com.vegetables.pojo.BaseUser;
import com.vegetables.pojo.Config;
import com.vegetables.pojo.Result;
import com.vegetables.util.DateUtils;
import com.vegetables.util.MD5;
import com.vegetables.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2018/4/23.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Config config;


    /**
     * 根据userName查询user信息
     * @param user
     * @return
     */
    public Result getUserByUserName(BaseUser user) throws Exception{
        BaseUser baseUser = userMapper.getUserByUserName(user.getUsername());
        if(baseUser==null){
            return ResultUtil.requestFaild("用户不存在");
        }
        String checkPassword = MD5.MD5(user.getPassword());
        if(!checkPassword.equals(baseUser.getPassword())){
            return ResultUtil.requestFaild("账号或密码错误");
        }
        return ResultUtil.requestSuccess("登陆成功");
    }

    /**
     * 根据userName查询user信息
     * @param param
     * @return
     */
    public Result uploadImg(Map<String,Object> param) throws Exception{
        int count = userMapper.insertBaseResource(param);
        if(count>0){
            return ResultUtil.requestSuccess("添加成功");
        }
        return ResultUtil.requestFaild("添加失败");
    }


    /**
     * 组装tree格式数据
     * @param param
     *        beginDate 开始日期
     *        endDate   结束日期
     * @return
     */
    public List<Map<String,Object>> getResourceList(Map<String,Object> param) throws Exception{
        List<Map<String,Object>> resourceList = userMapper.getBaseResource(param);
        List<Map<String,Object>> gorupDateRows = userMapper.getGorupDateRows(param);

        for(int i = 0;i<gorupDateRows.size();i++){
            Map<String,Object> temp = gorupDateRows.get(i);
            temp.put("id", UUID.randomUUID());
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            for(int j = 0;j<resourceList.size();j++){
                Map<String,Object> resource = resourceList.get(j);
                if(DateUtils.compare_date(temp.get("text").toString(),resource.get("createtime").toString())==0){
                    resource.put("imgurl",":"+config.getImg_drive()+resource.get("imgurl"));
                    //resource.put("text","<a href = '"+resource.get("imgurl")+"'>"+resource.get("text")+"</a>");
                    list.add(resource);
                }
            }
            temp.put("children",list);
        }

        List<Map<String,Object>> parengList = new ArrayList<Map<String,Object>>();
        Map<String,Object> parentMap = new HashMap<String,Object>();

        parentMap.put("id","0");
        parentMap.put("text","违规车牌");
        parentMap.put("children",gorupDateRows);

        parengList.add(parentMap);

        return parengList;
    }

    /**
     * 获取一个上传图片详细信息
     * @param id
     * @return
     */
    public Map<String,Object> getOneBaseResourceDetail(String id){
        Map<String,Object> map = userMapper.getOneBaseResourceDetail(id);
        map.put("imgurl",config.getHttp_img_url()+map.get("imgurl"));
        return map;
    }


    /**
     * 获取白名单列表
     * @return
     */
    public List<Map<String,Object>> getWhiteList(){
        /*List<Map<String,Object>> parentList = new ArrayList<Map<String,Object>>();
        Map<String,Object> parentMap = new HashMap<String,Object>();
        parentMap.put("id","0");
        parentMap.put("text","白名单列表");
        List<Map<String,Object>> whiteList = userMapper.getWhiteList();
        for(int i = 0;i<whiteList.size();i++){
            Map<String,Object> temp = whiteList.get(i);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",temp.get("id"));
            map.put("text",temp.get("text"));
            map.put("surplustime",temp.get("surplustime"));
            temp.put("attributes",map);

        }
        parentMap.put("children",whiteList);
        parentList.add(parentMap);*/
        return userMapper.getWhiteList();
    }

    /**
     * 修改白名单信息
     * @return
     */
    public String updateWhite(Map<String,Object> param){
        int count  = userMapper.updateWhite(param);
        if(count>0){
            return "00";
        }
        return  "01";
    }

    /**
     * 删除白名单信息
     * @return
     */
    public String deleteWhite(String id){
        int count  = userMapper.deleteWhite(id);
        if(count>0){
            return "00";
        }
        return "01";
    }

    /**
     * 根据车牌号查看白名单信息
     * @param platenum
     * @return
     */
    public Result getWhiteByPlateNum(String platenum) throws Exception{
        Map<String,Object> map = userMapper.getWhiteByPlateNum(platenum);
        if(map==null){
            return ResultUtil.requestSuccess(null,platenum+"车牌不在白名单中","01");
        }
        return ResultUtil.requestSuccess(JSONObject.toJSONString(map));
    }

    /**
     * 批量加入白名单信息
     * @param param
     * @return
     */
    public Result insertBatchWhite(List<Map<String,Object>> param) throws Exception{
        for(int i = 0;i<param.size();i++){
            if(param.get(i).get("var1")!=null&&!"".equals(param.get(i).get("var1"))){
                String str = param.get(i).get("var1").toString();
                if(str.contains(".")){
                    param.get(i).put("var1",str.substring(0,str.indexOf(".")));
                }
            }
        }
        int count = userMapper.insertBatchWhite(param);
        if(count>0){
            return ResultUtil.requestSuccess(null);
        }
        return ResultUtil.requestFaild("操作失败");
    }


}
