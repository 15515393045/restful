package com.car.admin.controller;

import com.car.admin.ServerEnums.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-05 22:11
 **/
@RestController
@RequestMapping("test")
public class TestInterface {


    @GetMapping("jsonData")
    public ResponseResult jsonData(){



        Map<String,Object> map2 = new HashMap();
        map2.put("name","张三");
        Map<String,Object> map3 = new HashMap();
        map3.put("age",19);
        Map<String,Object> map4 = new HashMap();
        map4.put("sex","男");

        Map<String,Object> map1 = new HashMap();
        map1.put("object2",map2);
        map1.put("object3",map3);
        map1.put("object4",map4);

        return ResponseResult.success(map1);
    }

}
