package com.car.admin.test55;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 13:44
 **/
public class CarDemo {

    //测试：Car类中的run方法。
    public static void main(String[] args) {
        // 1,创建Car的对象。给对象起个名字。
        Car car = new Car();// car是类类型的变量。car指向了一个具体的Car类型的对象。
        // 2,通过已有的对象调用该对象的功能。格式：对象.对象成员;
        // 3,可以该对象的属性赋值。
        car.carName = "宝马";
        car.color = "红色";
        car.number = 4;
        car.runCar();
    }

}
