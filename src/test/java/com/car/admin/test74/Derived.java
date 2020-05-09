package com.car.admin.test74;

import net.bytebuddy.implementation.bind.annotation.Super;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-07 18:05
 **/
public class Derived extends Base{
    /**
     由java初始化顺序，
     我们可知，初始化子类必须要先初始化父类，
     即子类构造器会隐式调用父类无参的构造器。
     如果父类没有无参构造器，
     那么子类必须要在构造器的第一行显示调用父类的有参构造器，将"super(s);"添上即可
    **/
    public Derived(String s){
        super(s);
    }

    public static void main(String[] args) {
        new Derived("c");
    }
}
