package com.car.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-04-19 16:59
 **/
@RestController
@RequestMapping("DataTest")
public class TestController {

    @PostMapping("reception")
    public void TestParameter(@RequestBody Map map){

    }

}
