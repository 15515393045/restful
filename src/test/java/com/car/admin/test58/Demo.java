package com.car.admin.test58;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 16:07
 **/
public class Demo {
    public static void main(String[] args) {
       Animal animal = new Dog();//多态形式，创建一个狗对象
        //animal.eat();// 调用对象中的方法，会执行狗类中的eat方法
        //((Dog) animal).lookHome();//使用Dog类特有的方法，需要向下转型，不能直接使用,向下转型。
        boolean b = animal instanceof Dog;
        System.out.println(b);

        /*Dog dog = (Dog) animal;
        dog.eat();
        dog.lookHome();*/

        // 为了使用狗类的lookHome方法，需要向下转型
        // 向下转型过程中，可能会发生类型转换的错误，即ClassCastException异常
        // 那么，在转之前需要做健壮性判断
        if (animal instanceof Dog){// 判断当前对象是否是Dog类型
            Dog dog = (Dog) animal;
            dog.eat();
            dog.lookHome();
        }else{
            System.out.println("类型不匹配，不能转换");
            return;
        }
    }
}
