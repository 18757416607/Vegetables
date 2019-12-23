package com.vegetables.springInit;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by admin188 on 2018/6/22.
 */
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

    Logger logger = Logger.getLogger(ApplicationFailedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        logger.info("......ApplicationFailedEvent......");
    }

}
