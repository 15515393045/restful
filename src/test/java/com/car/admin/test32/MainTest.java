package com.car.admin.test32;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-31 11:00
 **/
public class MainTest {

    public static void main(String[] args) {
        ShopFactory factory = new ShopFactory();

        IDrink drink = factory.getDrink();
        drink.runDrink();

        IEat eat = factory.getEat();
        eat.runEat();
    }

}
