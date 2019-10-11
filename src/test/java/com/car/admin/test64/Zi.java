package com.car.admin.test64;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-11 09:32
 **/
public class Zi extends RoleBean{

    Zi(){
        super();
        System.out.println(getAge());
        System.out.println(getName());
        System.out.println(getSex());
        String name = super.getName();//调用父类属性
        System.out.println(name);
        super.test();//调用父类方法
    }
    
    public void zi(){
        System.out.println("子类");
    }
}
