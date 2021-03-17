package com.car.admin.test91;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-09-06 22:48
 **/
public class CatTest {

    public static void main(String[] args) {
        // Cat cat = new Cat();
        // 其实做了两件事：
        // 1.Cat cat;声明一个Cat对象，对象名为cat。
        // 2. cat = new Cat();将cat对象实例化。
        //new 后面的Cat();就相当于调用了Cat类的构造方法。系统默认提供一个无参的构造方法。当你
        //手动声明构造方法后系统将不在提供。
        Cat cat = new Cat("丁丁");
        cat.setShoutNum(4);
        System.out.println(cat.shout());

        Cat cat1 = new Cat("咪咪");
        cat1.setShoutNum(5);
        System.out.println(cat1.shout());

        Dog dog = new Dog("欢欢");
        dog.setShoutNum(6);
        System.out.println(dog.shout());

        pig pig = new pig("花花");
        pig.setShoutNum(7);
        System.out.println(pig.shout());


        new Thread(() -> System.out.println("Test")).start();

        if("str".equals("test")){

        }

        //Alt+Enter万能建
        SimpleDateFormat format = new SimpleDateFormat();
        String format1 = format.format(new Date());
        System.out.println(format1);
        Date parse = null;
        try {
            parse = format.parse(format1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);

    }

}
