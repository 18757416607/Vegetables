package com.vegetables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
     * 去首页
     * @return
     */
    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }


    /*----------------------------------------------------------------- 蔬菜行情 start -----------------------------------------------------------------*/

    /**
     * 去蔬菜行情首页
     * @return
     */
    @GetMapping(value = "/goQuotationView")
    public String goQuotationView(){
        return "quotation/quotation";
    }


    /*----------------------------------------------------------------- 蔬菜行情  end   -----------------------------------------------------------------*/



    /*----------------------------------------------------------------- 蔬菜品种 start -----------------------------------------------------------------*/

    /**
     * 去蔬菜行情首页
     * @return
     */
    @GetMapping(value = "/goVarietiesView")
    public String goVarietiesView(){
        return "varieties/varieties";
    }


    /*----------------------------------------------------------------- 蔬菜品种  end   -----------------------------------------------------------------*/



    /*----------------------------------------------------------------- 蔬菜类别 start -----------------------------------------------------------------*/

    /**
     * 去蔬菜行情首页
     * @return
     */
    @GetMapping(value = "/goCategoryView")
    public String goCategoryView(){
        return "category/category";
    }


    /*----------------------------------------------------------------- 蔬菜类别  end   -----------------------------------------------------------------*/


}
