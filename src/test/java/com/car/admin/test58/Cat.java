package com.car.admin.test58;

/**
 * @program: demo-restful
 * @description: 描述猫类，继承动物类，重写eat方法，增加catchMouse方法
 * @author: zhanyh
 * @create: 2019-09-29 16:32
 **/
public class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("吃鱼");
    }
    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}
