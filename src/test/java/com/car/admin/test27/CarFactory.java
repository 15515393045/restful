package com.car.admin.test27;

import com.car.admin.test27.impl.AudiCar;
import com.car.admin.test27.impl.ISimpleCarImpl;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 19:38
 **/
public class CarFactory {

    public static ISimpleCar getCar(String type){

        if("bmw".equals(type)){
            return new ISimpleCarImpl();
        }else if("audi".equals(type)){
            return new AudiCar();
        }else{
            return null;
        }

    }




}
