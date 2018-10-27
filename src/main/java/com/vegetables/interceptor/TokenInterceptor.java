package com.vegetables.interceptor;

import com.vegetables.pojo.BaseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Administrator on 2018/3/28.
 * 请求验证token
 */
public class TokenInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws IOException {
        HttpSession session = httpServletRequest.getSession();
        System.out.println("进入拦截器");
        System.out.println(httpServletRequest.getServletPath());
        BaseUser baseUser = (BaseUser)session.getAttribute("userinfo");
        if(baseUser==null){
            //httpServletResponse.getWriter().print(new ObjectMapper().writeValueAsString(ResultUtil.requestFaild("请登陆后在操作")));
            httpServletResponse.sendRedirect("/vegetables/login");
            return false;
        }
        return true;
    }

    /**
     * controller 执行之后，且页面渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
