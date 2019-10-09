package com.car.admin.test58;

/**
 * @program: demo-restful
 * @description: 描述狗类，继承动物类，重写eat方法，增加lookHome方法
 * @author: zhanyh
 * @create: 2019-09-29 16:31
 **/
public class Dog extends Animal{
    @Override
    void eat() {
        System.out.println("啃骨头");
    }

    public void lookHome(){
        System.out.println("看家");
    }
}
