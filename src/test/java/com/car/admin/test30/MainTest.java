package com.car.admin.test30;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 22:52
 **/
public class MainTest {

    //普通
 /*   public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        IPhone xiaomi = factory.createPhone("小米");
        xiaomi.getPhone();
    }*/

/* 多个方法工厂模式
    public static void main(String[] args) {
        MoreFactoryMethod method = new MoreFactoryMethod();
        IPhone hongMi = method.getHongMi();
        hongMi.getPhone();
    }
*/

    public static void main(String[] args) {
        IPhone huaWei = MoreFactoryMethod.getHuaWei();
        huaWei.getPhone();
    }
}
