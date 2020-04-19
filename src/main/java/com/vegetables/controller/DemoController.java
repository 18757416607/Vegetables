package com.vegetables.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mloong on 2020/3/18.
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {


    @RequestMapping(value = "/test")
    public void test(String name, HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        // 复杂类型的request对象
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        // 获取文件名集合放入迭代器
        Iterator<String> files = mRequest.getFileNames();
        while (files.hasNext()) {
            // 获取上传文件的对象
            MultipartFile mFile = mRequest.getFile(files.next());
            if (mFile != null) {
                //原始文件名称
                String oldfile = mFile.getOriginalFilename();

                System.out.println(oldfile);

                //文件后缀
                String suffix = oldfile.substring(oldfile.indexOf('.'), oldfile.length());
                String suffix2 = oldfile.substring(oldfile.indexOf('.')+1, oldfile.length());
                /***************文件处理*********************/
            }
        }


    }





}
