package com.example.steel.boot;


import com.example.steel.data.MetaDataCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Slf4j
public class BootCenter {

    @Autowired
    private Environment environment;

    @PostConstruct
    private void boot(){
        log.info(">>>BootCenter running");
        innerDataInit();

    }



    private void innerDataInit(){
        log.info(">>>BootCenter innerDataInit");
        log.info("===MetaDataCache initData");
        MetaDataCache.boot(environment.getProperty("spring.profiles.active"));
    }



}
