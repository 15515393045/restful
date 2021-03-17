package com.car.admin.test91;

/**
 * @program: demo-restful
 * @description: 面向对象练习
 * @author: zhanyh
 * @create: 2020-09-06 22:44
 **/
public class Cat extends Animal{

//在子类的有参构造方法中的第一行加上super.(父类的参数类型和个数);
    public Cat(String name){
        super(name);
    }

    public Cat(){
        super();
    }

    //猫叫方法
    public String shout(){
        String result = "";
        for (int i = 0; i < shoutNum; i++) {
            result += "喵  ";
        }

        return "我的名字叫"+name+"\t"+result;
    }


}
