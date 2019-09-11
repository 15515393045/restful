package com.car.admin.test36;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-09 11:31
 **/
public class StaticTest{

    public static  class  InnerClass{
        InnerClass(){
            System.out.println("============= 我是一个内部类'InnerClass' =============");
        }
    }

    StaticTest(){
        System.out.println("我是一个类");
    }

}
