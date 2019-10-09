package com.car.admin.test59;

/**
 * @program: demo-restful
 * @description: 构造方法
 * @author: zhanyh
 * @create: 2019-09-29 16:57
 **/
public class Person {
    // Person的成员属性age和name
    private int age;
    private String name;
    // Person的构造方法，拥有参数列表
    Person(int stuAge, String stuName){
        // 接受到创建对象时传递进来的值，将值赋给成员属性
        age = stuAge;
        name = stuName;
    }
}
