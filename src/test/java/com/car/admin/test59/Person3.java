package com.car.admin.test59;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 17:22
 **/
public class Person3 {

    private int age;
    private String name;

    // 给姓名和年龄初始化的构造方法
    Person3(int age, String name){
        // 当需要访问成员变量是，只需要在成员变量前面加上this.即可
        this.age = age;
        this.name = name;
    }

    public void speak() {
        System.out.println("name=" + this.name + ",age=" + this.age);
    }

}
