package com.car.admin.test91;

import org.apache.logging.log4j.util.StringBuilderFormattable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-09-06 23:52
 **/
public class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    public Dog(){
        super();
    }

    //猫叫方法
    public String shout(){

        String result = "";
        for (int i = 0; i < shoutNum; i++) {
            result += "汪  ";
        }

        return "我的名字叫"+name+"\t"+result;
    }



}
