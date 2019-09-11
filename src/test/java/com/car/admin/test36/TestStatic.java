package com.car.admin.test36;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-09 11:48
 **/
public class TestStatic {

    public static void main(String[] args) {
        //调用内部类
        new StaticTest.InnerClass();
        //调用普通类
        new StaticTest();
    }

}
