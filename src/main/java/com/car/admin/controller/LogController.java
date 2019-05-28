package com.car.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LogController {

       @GetMapping("log") public void testLog(){

           log.debug("debug message 1  日");
           log.warn("warn message 2   志");
           log.info("info message 3  记");
           log.error("error message 4  录");
           log.trace("trace message 5  。");

       }


}
