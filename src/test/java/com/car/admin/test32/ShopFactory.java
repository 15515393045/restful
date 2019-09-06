package com.car.admin.test32;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-31 10:57
 **/
public class ShopFactory implements IFactory{


    @Override
    public IDrink getDrink() {
        return new IDrink.DrinkCola();
    }

    @Override
    public IEat getEat() {
        return new IEat.EatBread();
    }
}
