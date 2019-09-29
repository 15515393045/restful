package com.car.admin.test59;

/**
 * @program: demo-restful
 * @description: 父类
 * @author: zhanyh
 * @create: 2019-09-29 17:30
 **/
public class Fu {
    private String name;
    int num;
    Fu(){
        name = "父类的构造方法";//先赋值
        System.out.println("Fu构造方法："+name);//在输出
        System.out.println("Fu构造方法："+num);
        num  = 6;

    }
}
