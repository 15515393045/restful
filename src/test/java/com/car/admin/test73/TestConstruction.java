package com.car.admin.test73;

import java.lang.reflect.Constructor;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-04-19 15:54
 **/
class Dog{

    public Dog(String color){
        System.out.println("狗");
    }

}

public class TestConstruction{
    public static void main(String[] args) throws Exception{
        Class<Dog> dogClass = Dog.class;
        //Dog dog = dogClass.newInstance();
        Constructor<Dog> constructor = dogClass.getConstructor(String.class);
        Dog blue = constructor.newInstance("blue");
        System.out.println(blue);
    }
}