package com.car.admin.test27.impl;

import com.car.admin.test27.ISimpleCar;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 19:37
 **/
public class AudiCar implements ISimpleCar {

    @Override
    public void makeCar() {
        System.out.println("奥迪");
    }

}
