package com.car.admin.test73;

import java.lang.reflect.Array;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-04-19 16:05
 **/
public class TestArray {

    public class Dog{

    }

    public static void main(String[] args) {
        Dog[] dogs = (Dog[]) Array.newInstance(Dog.class, 3);
        System.out.println(dogs.length);
    }
}
