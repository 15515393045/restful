package com.car.admin.test30;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 23:01
 **/
public class MoreFactoryMethod {
    //小米工厂
    public static IPhone getXiaoMi(){
        return new XiaoMi();
    }
    //华为工厂
    public static IPhone getHuaWei(){
        return new HuaWei();
    }
    //红米工厂
    public static IPhone getHongMi(){
        return new HongMi();
    }

}
