package com.car.admin.test32;

/**
 * @program: demo-restful
 * @description: 工厂
 * @author: zhanyh
 * @create: 2019-08-31 10:56
 **/
public interface IFactory {
    //喝的工厂类
    IDrink getDrink();
    //吃的工厂类
    IEat getEat();

}
