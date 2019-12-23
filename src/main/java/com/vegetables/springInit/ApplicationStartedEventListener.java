package com.vegetables.springInit;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2018/6/22.
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    Logger logger = Logger.getLogger(ApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        logger.info("------------ApplicationStartedEventListener-------------");
    }
}
