package com.car.admin.test59;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 17:15
 **/
public class Person1 {
    private int age;
    private String name;
    // 无参数的构造方法
    Person1(){}
    // 给姓名初始化的构造方法
    Person1(String stuName){
        name = stuName;
    }
    // 给姓名和年龄初始化的构造方法
    Person1(String stuName,int stuAge){
        // 由于已经存在给姓名进行初始化的构造方法 name = nm;因此只需要调用即可
        this(stuName);
        // 给年龄初始化
        age = stuAge;
    }
}
