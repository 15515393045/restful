package com.car.admin.test27;

import com.car.admin.test27.impl.AudiCar;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 20:20
 **/
public class AudiFactory implements IFactory{
    @Override
    public ISimpleCar getCar() {
        return new AudiCar();
    }
}
