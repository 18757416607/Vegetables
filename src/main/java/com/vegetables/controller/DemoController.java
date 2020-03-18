package com.vegetables.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

/**
 * Created by Mloong on 2020/3/18.
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {


    @RequestMapping(value = "/test")
    public void test(InputStream inputStream,String ftpPath,String fileName){
        System.out.println("ftpPath:"+ftpPath);
        System.out.println("fileName:"+fileName);


    }

}
