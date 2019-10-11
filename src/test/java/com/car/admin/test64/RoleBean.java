package com.car.admin.test64;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-30 17:12
 **/
@Data
public class RoleBean implements Serializable {

    private String name;
    private int age;
    private String sex;

    public RoleBean(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    RoleBean(){
        name = "李四";
        age = 12;
        sex = "男";
    }

    RoleBean(String name){
        this.name = name;
    }

    public void test(){
        System.out.println(name+age+sex);
    }
}
