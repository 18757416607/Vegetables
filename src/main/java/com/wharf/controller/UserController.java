package com.wharf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wharf.pojo.BaseUser;
import com.wharf.pojo.Result;
import com.wharf.service.UserService;
import com.wharf.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by Administrator on 2018/4/23.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 验证登陆
     * @param user
     * @param request
     * @return
     */
    @PostMapping(value = "/checkLogin")
    public Result checkLogin(BaseUser user, HttpServletRequest request){
        try{
            Result result = userService.getUserByUserName(user);
            if(result.getCode().equals("00")){
                HttpSession session = request.getSession();
                session.setAttribute("userinfo",user);
            }
            System.out.println(request.toString());
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.requestFaild("登陆异常,请联系一咻工作人员!");
        }
    }


    /**
     *  获取图片资源信息
     * @param beginDate  开始日期
     * @param endDate    结束日期
     * @return
     */
    @PostMapping(value = "/getResourceList")
    public List<Map<String,Object>> getResourceList(String beginDate,String endDate){
        try{
            if(beginDate==null||"".equals(beginDate)){
                beginDate = DateUtils.getCurrStrDate()+" 00:00:00";
            }
            if(endDate==null||"".equals(endDate)){
                endDate = DateUtils.getCurrStrDate()+" 23:59:59";
            }
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("beginDate",beginDate);
            param.put("endDate",endDate);
            return userService.getResourceList(param);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  获取一个上传图片详细信息
     * @return
     */
    @PostMapping(value = "/getOneBaseResourceDetail")
    public Map<String,Object> getOneBaseResourceDetail(String id){
        try{
            return userService.getOneBaseResourceDetail(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/t")
    public void t(){
        File f = new File(UserController.class.getResource("/").getPath());
        String path = f.getParentFile().getParent()+"\\";
        System.out.println(path);
    }


    /**
     * 上传图片
     * @param request
     * @param mtpreq  获取支持文件上传的Request对象 MultipartHttpServletRequest
     * @param platenum
     * @param description
     * @return
     */
    @PostMapping(value = "/uploadImg")
    public Result uploadImg(HttpServletRequest request,MultipartHttpServletRequest mtpreq,String platenum,String description){
        try{
            //通过 mtpreq 获取文件域中的文件
            MultipartFile file = mtpreq.getFile("image");
            //通过MultipartFile 对象获取文件的原文件名
            String fileName = file.getOriginalFilename();
            //生成一个uuid 的文件名
            UUID randomUUID = UUID.randomUUID();
            //获取文件的后缀名
            int i = fileName.lastIndexOf(".");
            String uuid = randomUUID.toString();
            String uuidName =  uuid + fileName.substring(i);
            //获取服务器的路径地址（被上传文件的保存地址）

            //D:\Tools\tomcat8.5\webapps\wharf\WEB-INF\classes\static\fileImg
            File f = new File(UserController.class.getResource("/").getPath());
            String realPath = f.getParentFile().getParent()+"\\WEB-INF\\classes\\static\\fileImg";

            //tring realPath = "C:/file";//request.getSession().getServletContext().getRealPath("/file");
            //将路径转化为文件夹 并 判断文件夹是否存在
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //获取一个文件的保存路径
            String path = realPath + "/" + uuidName;

            // 为文件这服务器中开辟一给新的空间,*没有数据
            // File newFile = new File(path);

            file.transferTo(new File(path));

            System.err.println("-----服务器的路径地址为：:" + realPath);
            System.err.println("-----图片名称为：:" + fileName);
            System.err.println("-----图片新名称为：:" + uuidName);
            System.err.println("-----图片新路径为：:" + path);

            Map<String,Object> param = new HashMap<String,Object>();
            param.put("resname",uuid);
            param.put("platenum",platenum);
            param.put("imgurl",uuid+fileName.substring(fileName.indexOf("."),fileName.length()));
            param.put("description",description);

            Result result = userService.uploadImg(param);
            if(result.getCode().equals("00")){
                return ResultUtil.requestSuccess("上传成功");
            }else{
                return ResultUtil.requestFaild("上传失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.requestFaild(e.getMessage());
        }
    }


    /**
     * 获取白名单列表
     * @return
     */
    @PostMapping(value = "/getWhiteList")
    public List<Map<String,Object>> getWhiteList(){
        try{
            return userService.getWhiteList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改白名单数据
     * @return
     */
    @PostMapping(value = "/updateWhite")
    public String updateWhite(String realname,String phone,String dept,String surplustime,String id){
        try{
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("realname",realname);
            param.put("phone",phone);
            param.put("dept",dept);
            param.put("surplustime",surplustime);
            param.put("id",id);
            return userService.updateWhite(param);
        }catch (Exception e){
            e.printStackTrace();
            return "01";
        }
    }

    /**
     * 删除白名单数据
     * @return
     */
    @PostMapping(value = "/deleteWhite")
    public String deleteWhite(String id){
        try{
            return userService.deleteWhite(id);
        } catch (Exception e){
            e.printStackTrace();
            return "01";
        }
    }


    /**
     * 根据车牌号查看白名单信息
     * @param platenum
     * @return
     */
    @GetMapping(value = "/getWhiteByPlateNum")
    public Result getWhiteByPlateNum(String platenum){
        try{
            return userService.getWhiteByPlateNum(platenum);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.requestFaild(e.getMessage());
        }
    }

    /**
     * 导入白名单信息
     * @param file
     * @param model
     * @return
     */
    @PostMapping(value = "/whiteImport")
    public String whiteImport(@RequestParam(value="excel",required=false) MultipartFile file, Model model){
        try{
            if (null != file && !file.isEmpty()) {
                String filePath = PathUtil.getClasspath() + "uploadFiles/";								//文件上传路径
                String fileName = FileUpload.fileUp(file, filePath, "unionPayWallet");							//执行上传
                List<Map<String,Object>> listPd = (List) ObjectExcelRead.readExcel(filePath, fileName,1, 0, 0);		//执行读EXCEL操作,读出的数据导入List 2:从第3行开始；0:从第A列开始；0:第0个sheet
                Result result = userService.insertBatchWhite(listPd);
                if(result.getCode().equals("00")){
                    model.addAttribute("msg","白名单数据上传成功");
                    return result.getCode();
                }else{
                    model.addAttribute("msg","白名单数据上传失败,请检查Excel中是否有内容或联系一咻工作人员");
                    return result.getCode();
                }
            }else{
                return "-1";
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg","白名单数据上传失败,重新操作或联系一咻工作人员");
            return "-1";
        }
    }

    /**
     * 下载白名单导入模板
     * @return
     */
    @GetMapping(value = "/templateDown")
    public void templateDown(HttpServletResponse response,HttpServletRequest request){
        try{
            FileDownload.fileDownload(response,request,PathUtil.getClassResources() + "static/template/白名单模板.xls", "白名单模板.xls");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
