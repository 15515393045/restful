package com.car.admin.test56;

/**
 * @program: demo-restful
 * @description: 定义研发部员工类Developer 继承 员工类Employee
 * @author: zhanyh
 * @create: 2019-09-29 14:21
 **/
public class Developer extends Employee{
    // 定义一个打印name的方法
    public void printName() {
        System.out.println("name=" + name);
    }
}
