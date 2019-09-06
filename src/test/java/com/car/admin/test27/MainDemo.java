package com.car.admin.test27;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 20:21
 **/
public class MainDemo {

    public static void main(String[] args) {

      /*  IFactory audiFactory = new AudiFactory();
        ISimpleCar car = audiFactory.getCar();
        car.makeCar();*/

        IFactory bwmFactory = new BWMFactory();
        ISimpleCar car = bwmFactory.getCar();
        car.makeCar();
    }

}
