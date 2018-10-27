package com.wharf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/23.
 * 页面跳转controller
 */
@Controller
public class ViewController {

    /**
     * 去登陆页面
     * @return
     */
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }


    /**
     * 去显示资源信息页面
     * @return
     */
    @GetMapping(value = "/goResourceView")
    public String goResourceView(){
        return "resource";
    }

}
