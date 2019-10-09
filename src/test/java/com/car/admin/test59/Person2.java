package com.car.admin.test59;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 17:20
 **/
public class Person2 {
    private int age;
    private String name;
    // 私有无参数的构造方法，即外界不能通过new Person();语句创建本类对象
    private Person2(){}

    // 多个构造方法是以重载的形式存在
    Person2(int stuAge){
        age = stuAge;
    }

    Person2(String stuName,int stuAge){
        name = stuName;
        age = stuAge;
    }
}
