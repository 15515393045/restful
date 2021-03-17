package com.car.admin.test91;

/**
 * @program: demo-restful
 * @description: 动物类，基类，父类
 * @author: zhanyh
 * @create: 2020-09-06 23:53
 **/
public class Animal {

    //定义私有的猫咪名称属性
    //protected权限只对子类开发
    protected String name = "";
    //定义猫咪叫声次数的字段默认三次
    protected int shoutNum = 3;


    //手动声明有参构造函数
    public Animal(String name){
        this.name = name;
    }

    //方法的重载 无参构造
    public Animal(){

    }

    //get  set方法
    public int getShoutNum() {
        return shoutNum;
    }

    public void setShoutNum(int shoutNum) {

        //设置最多叫10次
        if(shoutNum <= 10){
            this.shoutNum = shoutNum;
        }else{
            this.shoutNum = 10;
        }

    }

}
