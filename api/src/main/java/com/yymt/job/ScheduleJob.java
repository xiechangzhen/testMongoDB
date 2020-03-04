package com.yymt.job;

import com.yymt.common.utils.R;
import com.yymt.modules.controller.sport.SearchController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 描述:${DESCRIPTION}
 * 作者:Administrator
 * 时间:2018-05-18 16:33
 **/
@Component
public class ScheduleJob {


    private static final Logger logger = LoggerFactory.getLogger(ScheduleJob.class);

    @Autowired
    SearchController searchController;

    @Scheduled(cron = "0 0 23 ? * *")
    public void executeGeneratorTask() throws IOException {
        searchController.buildIndexData("yymt.com");
    }

}
