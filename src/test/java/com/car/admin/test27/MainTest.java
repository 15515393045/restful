package com.car.admin.test27;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 19:42
 **/
public class MainTest {

    public static void main(String[] args) {
        /*ISimpleCar car = CarFactory.getCar("audi");
        car.makeCar();*/

        //多个方法工厂
     /*   FactoryMethods factoryMethods = new FactoryMethods();
        ISimpleCar audi = factoryMethods.getAudi();
        audi.makeCar();*/

     //多个静态方法
        ISimpleCar bwm = FactoryMethods.getBWM();
        bwm.makeCar();
    }

}
