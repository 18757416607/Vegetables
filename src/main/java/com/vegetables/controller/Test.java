package com.vegetables.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mloong on 2020/3/18.
 */
@RestController
@RequestMapping(value = "/t")
public class Test {

    private static Logger log = Logger.getLogger(Test.class);


    @RequestMapping(value ="t")
    public void test() throws Exception{
        File f = new File("D://1.png");

        PostMethod filePost = new PostMethod( "http://127.0.0.1:8083/vegetables/demo/test?name=123465");



        HashMap<String,Object> param = new HashMap<>();
        param.put("name","1234");
        //filePost.addParameter("params",JSONObject.toJSONString(param));
        filePost.addParameter("name","1234165");


        //设定参数名称和值，类似form表单中的<input name="filename” type="file" />
        Part[] parts = { new FilePart("filename", f,"multipart/form-data","UTF-8")};

        //设置多媒体参数，作用类似form表单中的enctype="multipart/form-data" ，
        filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));

        HttpClient clients = new HttpClient();


        int status = clients.executeMethod(filePost);

        try {

            BufferedReader rd = new BufferedReader(new InputStreamReader(  filePost.getResponseBodyAsStream(), "UTF-8"));

            StringBuffer stringBuffer = new StringBuffer();

            String line;

            while ((line = rd.readLine()) != null) {

                stringBuffer .append(line);

            }

            rd.close();

            System.out.println("接受到的流是：" + stringBuffer + "—-" + status);

        } catch (Exception e) {

            throw new RuntimeException("error",e);

        }

    }




}
