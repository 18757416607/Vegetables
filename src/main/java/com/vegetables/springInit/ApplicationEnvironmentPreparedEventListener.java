package com.vegetables.springInit;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by admin188 on 2018/6/22.
 */
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    Logger logger = Logger.getLogger(ApplicationEnvironmentPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        logger.info("......ApplicationEnvironmentPreparedEvent......");
    }

}
