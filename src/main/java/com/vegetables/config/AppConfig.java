package com.vegetables.config;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class AppConfig {

    Logger logger = Logger.getLogger(AppConfig.class);

    @Bean
    public ScheduledThreadPoolExecutor scheduledExecutorService() {
        logger.info("开始AppConfig线程-------");
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        logger.info("结束返回AppConfig线程---------");
        return executor;
    }

}
