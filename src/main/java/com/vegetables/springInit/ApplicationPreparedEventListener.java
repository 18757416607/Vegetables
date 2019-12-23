package com.vegetables.springInit;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2018/6/22.
 */
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    Logger logger = Logger.getLogger(ApplicationPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        logger.info("--------------ApplicationPreparedEventListener----------------");
    }
}
