package com.vegetables.springInit;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by admin188 on 2018/6/22.
 */
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    Logger logger = Logger.getLogger(ApplicationStartingEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        logger.info("......ApplicationStartingEvent......");
    }

}
