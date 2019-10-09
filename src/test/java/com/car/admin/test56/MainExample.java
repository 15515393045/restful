package com.car.admin.test56;

/**
 * @program: demo-restful
 * @description: 定义测试类
 * @author: zhanyh
 * @create: 2019-09-29 14:22
 **/
public class MainExample {
    public static void main(String[] args) {
        Developer developer = new Developer();// 创建一个研发部员工类对象（子类）
        developer.name = "小米"; // 为该员工类的name属性进行赋值
        developer.printName(); // 调用该员工的printName()方法
        developer.work();// 调用Developer类继承来的work()方法
    }
}
