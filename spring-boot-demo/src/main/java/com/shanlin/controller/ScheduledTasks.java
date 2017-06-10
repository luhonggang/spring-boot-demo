package com.shanlin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by hezuchao on 2017/6/9.
 */
@Component
public class ScheduledTasks {
    private static final Logger logger = LogManager.getLogger(ScheduledTasks.class.getName());
    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() {
        logger.info("现在时间：" + new DateTime().toString("yyyy-MM-dd hh:mm:ss"));
    }
}
