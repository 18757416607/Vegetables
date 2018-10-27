package com.vegetables.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Administrator on 2018/3/16.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/user/checkLogin")
                .excludePathPatterns("/user/uploadImg")
                .excludePathPatterns("/user/getWhiteByPlateNum")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/templates/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态资源映射
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        ///将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
