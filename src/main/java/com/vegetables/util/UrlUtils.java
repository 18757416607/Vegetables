package com.vegetables.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Mloong on 2020/2/28.
 */
public class UrlUtils {

    private Logger log = Logger.getLogger(UrlUtils.class);


    /**
     * tdh调用
     * @param startMap
     * @return
     */
    public  JSONObject startDyTdh(Map<String, Object> startMap) {
        log.info("调用内网中心--开始");
        JSONObject result = new JSONObject();
        HttpClient httpClient = null;
        PostMethod httpMethod = null;
        try {
            JSONObject param = JSON.parseObject(JSON.toJSONString(startMap));

            StringRequestEntity entity = null;
            //httpClient = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));

            httpClient = new HttpClient();

            httpMethod = new PostMethod("http://127.0.0.1:8083/vegetables/test/t1");

            httpMethod.addRequestHeader("Content-Type", "application/json");
            entity = new StringRequestEntity(param.toString(), "application/json", "utf-8");
            httpMethod.setRequestEntity(entity);
            httpMethod.setHttp11(true);
            httpClient.setTimeout(15000);
            httpClient.setConnectionTimeout(15000);
            httpClient.executeMethod(httpMethod);
            String response = getStringForResponse(httpMethod);
            result = JSON.parseObject(response);
        } catch (Exception e) {
            log.error("调用内网接口异常:",e);
            throw new RuntimeException("调用异常");
        }finally {
            // 释放资源
            if (httpMethod != null) {
                httpMethod.releaseConnection();
                httpMethod = null;
            }
            if (httpClient != null) {
                httpClient.getHttpConnectionManager().closeIdleConnections(0L);
                httpClient = null;
            }
        }
        return result;
    }


    public String getStringForResponse(PostMethod httpMethod) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpMethod.getResponseBodyAsStream(),"UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        while((str = reader.readLine())!=null){
            stringBuffer.append(str);
        }
        String ts = stringBuffer.toString();
        return ts;
    }


    public static void main(String[] args) {
        /*UrlUtils request = new UrlUtils();
        Map<String,Object> param = new HashMap<>();
        param.put("a","1");
        param.put("a","1");
        param.put("a","1");
        param.put("a","1");
        System.out.println(request.startDyTdh(param));*/




    }


}
