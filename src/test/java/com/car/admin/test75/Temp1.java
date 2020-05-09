package com.car.admin.test75;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-09 21:03
 **/
public class Temp1 {

    static int t;//类变量，

    public static void main(String[] args) {
        System.out.println(t+"  111");//打印类变量

        int t = 1;//局部变量，必须赋初始值。

        System.out.println(t+"   222");//打印局部变量

        Temp1 temp1 = new Temp1();//创建实例对象

        System.out.println(temp1.t+"  333");//通过实例来访问实例变量
    }

}
