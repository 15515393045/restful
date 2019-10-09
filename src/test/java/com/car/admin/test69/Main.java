package com.car.admin.test69;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-09 13:49
 **/
public class Main {

    public static void main(String[] args) {
        /*
        为什么要用通配符和边界？
          在使用泛型的过程中经常会出现这种情况，基类，派生类，容器类。
            容器类里面可以放一个泛型的“东西”。
            我们可以对这个东西做最简单的“放”和“取”的动作：set()和get()方法。
            在容器类中如果想要把派生类的引用传给基类就会报错，
            计算容器类里面的东西有继承关系，但是容器之间是没有继承关系的。
            所以就不能把派生类的引用赋给基类。
            为了让泛型用起来更舒服，
            于是就有了<? extends T>和< super T>的办法，
            来让基类和派生类有联系。

           Java编译器不允许这个操作，会报错。
           Type mismatch: cannot convert from Plate<Apple> to Plate<Fruit>
           容器里装的东西之间有继承关系但是容器之间是没有继承关系。所以会编辑报错。
         */
        //Plate<Fruit> plate = new Plate<Apple>(new Apple());

        // Plate容器类
        //上界<? extends T>不能往里存，只能往外取
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
        Fruit fruit = plate.get();
        Object fruit1 = plate.get();
        //plate.set(new Apple());Error 编译失败
        //plate.set(new Fruit());Error 编译失败

        // Plate容器类
        //下界<? super T>不影响往里存，但往外取只能放在Object对象里
        Plate<? super Fruit> p = new Plate<>(new Apple());
        //存入元素正常
        //p.set(new Fruit()); 赋值水果类，Success
        p.set(new Apple());//对容器类进行赋值水果类的派生类（子类）苹果。

        /*
            因为下界规定了元素的最小粒度的下限，
            实际上是放松了容器元素的类型控制。
            既然元素是Fruit的基类，那往里存粒度比Fruit小的都可以。
            但往外读取元素就费劲了，只有所有类的基类Object对象才能装下。
            但这样的话，元素的类型信息就全部丢失。
        */
        //Fruit object1 = p.get(); 编辑报错
        //Fruit object1 = p.get(); 编辑报错
        Object object = p.get();
        /*
        通过下界值能取出Object类型的对象，
        以为Object是所以对象的父类。
        下届并不知道里面的类型到底是啥。
        将其强制转换为苹果类（派生类）即可调用基类（父类）和派生类（子类）里面的方法。
        */
        Apple apple = (Apple) object;
        apple.apple();
        apple.fruit();
    }

}
