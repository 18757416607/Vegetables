package com.vegetables.controller;

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
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mloong on 2020/3/18.
 */
public class Test {

    private static Logger log = Logger.getLogger(Test.class);


    public static void main(String[] args) throws Exception{
        download("","","");
        String dz = "D:\\" + "0.5021192564980266.o6zAJsxlgc6iMeW43OSJDd9ewEww.wuWWY5hnmo7r8f53eb89dcf4715ead55ca853ac7b0f4.png";
        log.debug("文件下载完成路径:"+dz);
        File file  = new File(dz);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InputStream fileIn = new FileInputStream(file);
        byte[] b = new byte[1024];
        int n;
        while ((n = fileIn.read(b)) != -1)
        {
            bos.write(b, 0, n);
        }

        byte[] buffer = bos.toByteArray();


        MultipartFile wjfile = new MockMultipartFile("新文件名","原文件名", ContentType.APPLICATION_OCTET_STREAM.toString(), fileIn);
        Map<String,Object> param = new HashMap<>();
        param.put("file",wjfile);
        param.put("ftpPath","C:\\");
        param.put("fileName","0.5021192564980266.o6zAJsxlgc6iMeW43OSJDd9ewEww.wuWWY5hnmo7r8f53eb89dcf4715ead55ca853ac7b0f4.png");
        param.put("key","0.5021192564980266.o6zAJsxlgc6iMeW43OSJDd9ewEww.wuWWY5hnmo7r8f53eb89dcf4715ead55ca853ac7b0f4.png");
        log.debug("上传ftp入参:"+param);




        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        httpPost = new HttpPost("http://127.0.0.1:8083/vegetables/demo/test");
        httpPost.addHeader("Authorization", "76f3511f-8ddd-40c9-8c2a-cefe9a4b10f8");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setCharset(java.nio.charset.Charset.forName("UTF-8"));
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        MultipartFile multipartFile = (MultipartFile)param.get("file");

        builder.addBinaryBody("file", multipartFile.getInputStream(), ContentType.MULTIPART_FORM_DATA, (String)param.get("fileName"));// 文件流
        ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            if(entry.getValue() == null || (entry.getValue() instanceof MultipartFile))
                continue;
            // 类似浏览器表单提交，对应input的name和value
            builder.addTextBody(entry.getKey(), entry.getValue().toString(), contentType);
        }
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);// 执行提交

        // 设置连接超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000).setSocketTimeout(10000).build();
        httpPost.setConfig(requestConfig);

        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            // 将响应内容转换为字符串
            String response_str = EntityUtils.toString(responseEntity, java.nio.charset.Charset.forName("UTF-8"));
            System.out.println("返回数据:"+response_str);
        }else{
            System.out.println("nonononono");
        }

        fileIn.close();
        bos.close();


    }


    /**
     * 下载附件到本地
     * @param urlString 附件公网地址
     * @param filename  文件名称
     * @param savePath  存在地址（绝对路径）
     * @throws Exception
     */
    public static void download(String urlString, String filename,String savePath){
        InputStream is = null;
        OutputStream os = null;
        urlString = "https://tx-1259536957.cos.ap-shanghai.myqcloud.com/0.5021192564980266.o6zAJsxlgc6iMeW43OSJDd9ewEww.wuWWY5hnmo7r8f53eb89dcf4715ead55ca853ac7b0f4.png";
        savePath = "D:\\";
        filename = "0.5021192564980266.o6zAJsxlgc6iMeW43OSJDd9ewEww.wuWWY5hnmo7r8f53eb89dcf4715ead55ca853ac7b0f4.png";
        try{
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5*1000);
            con.setReadTimeout(10*1000);
            is = con.getInputStream();
            log.info("cos文件输入流获取成功。。。。。。。。。。");

            byte[] bs = new byte[1024];
            int len;
            java.io.File sf=new java.io.File(savePath);
            if(!sf.exists()){
                sf.mkdirs();
            }

            File localFile = new File(savePath + File.separatorChar + filename);
            if(!localFile.exists()){
                localFile.createNewFile();
            }

            log.info("本地下载开始。。。。。。。。。。。");
            os = new FileOutputStream(localFile);
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            os.flush();
        }catch (Exception e){
            log.error("从cos下载材料异常:",e);
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
