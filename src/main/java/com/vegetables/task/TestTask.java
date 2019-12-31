package com.vegetables.task;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
public class TestTask {

    Logger logger = Logger.getLogger(TestTask.class);

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        logger.info("执行静态定时任务时间: " + LocalDateTime.now());

    }

}
