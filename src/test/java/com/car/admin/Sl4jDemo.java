package com.car.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Sl4jDemo {

    private final Logger logger = LoggerFactory.getLogger(Sl4jDemo.class);

    //注解
    @Test
    public void test1(){
        log.debug("debug message 1");
        log.warn("warn message 2");
        log.info("info message 3");
        log.error("error message 4");
        log.trace("trace message 5");
    }

    //传统
    @Test
    public void test2(){
        logger.info("info----1");
        logger.debug("debug----2");
        logger.warn("warn----3");
        logger.error("error----4");
        logger.trace("trace----5");
    }
}
