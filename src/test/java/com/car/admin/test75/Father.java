package com.car.admin.test75;

/**
 * @program: demo-restful
 * @description:
 * 优先执行父类的静态方法。其次执行父类的静态块。然后执行子类的静态方法，其次执行子类的
 * 静态块。接着执行子类的非静态方法执行完毕后回到父类执行父类中的语句块紧接着执行父类中的
 * 构造方法。执行完毕后，回到子类执行子类的非静态方法，接着执行子类的语句块，子类的构造方法，
 *
 * 第二次实例化子类则不会在执行父类和子类中的静态方法和静态块，先执行子类的非静态方法，其次
 * 执行父类的语句块和构造方法执行完毕后回到子类执行子类的语句块和构造方法。
 * @author: zhanyh
 * @create: 2020-05-09 23:37
 **/
public class Father {

    private int i = Test();

    private static int j = Method();

    static {
        System.out.println("(1)");
    }

    Father(){
        System.out.println("(2)");
    }

    {
        System.out.println("(3)");
    }

    public int Test(){
        System.out.println("(4)");
        return 4;
    }


    public static int Method(){
        System.out.println("(5)");
        return 5;
    }


}
