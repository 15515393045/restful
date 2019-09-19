package com.car.admin.controller;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.util.DatabaseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("dataBaseInfo")
    public ResponseResult dataBaseInfo(){
        Map<String,Object> tableNameMap = new HashMap<>();
        Map<String,Object> columnNameMap = new HashMap<>();
        Map<String,Object> columnTypesMap = new HashMap<>();
        Map<String,Object> columnCommentsMap = new HashMap<>();
        //获取所有表名
        List<String> tableNames = DatabaseUtil.getTableNames();
        tableNameMap.put("tableNames",tableNames);
        //循环所有表名
        for (String tableName : tableNames) {
            //通过表名获取字段名称
            List<String> columnNames = DatabaseUtil.getColumnNames(tableName);
            columnNameMap.put("ColumnNames",columnNames);
            //通过表名获取字段类型
            List<String> columnTypes = DatabaseUtil.getColumnTypes(tableName);
            columnTypesMap.put("ColumnTypes",columnTypes);
            //通过表名获取字段描述
            List<String> columnComments = DatabaseUtil.getColumnComments(tableName);
            columnCommentsMap.put("ColumnComments",columnComments);
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        listMap.add(tableNameMap);
        listMap.add(columnNameMap);
        listMap.add(columnTypesMap);
        listMap.add(columnCommentsMap);

        return ResponseResult.success(listMap);
    }

}
