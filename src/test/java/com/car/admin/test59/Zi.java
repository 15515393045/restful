package com.car.admin.test59;

/**
 * @program: demo-restful
 * @description: 子类
 * @author: zhanyh
 * @create: 2019-09-29 17:32
 **/
public class Zi extends Fu{
    Zi(){
        //super();//调用父类空参数构造方法 隐式的super();
        System.out.println("Zi构造方法："+num+"为父类的属性。");
    }
}
