package com.car.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.form.InputTag;
import sun.util.resources.hr.CalendarData_hr;

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

    @Test
    public void test3(){
        char word = 'd', word2 = '@';

        int p = 23045, p2 = 45213;

        System.out.println("d在Unicode表中的顺序位置是："+(int)word);
        System.out.println("@在Unicode表中的顺序位置是："+(int)word2);
        System.out.println("unicode表中第23045位的是："+(char)p);
        System.out.println("unicode表中第45213位的是："+(char)p2);
    }

    @Test
    public void test4(){
        char c1 = '\\';

        char c2 = '\u2605';

        System.out.println(c1);
        System.out.println(c2);

    }
}
