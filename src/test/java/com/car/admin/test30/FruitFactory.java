package com.car.admin.test30;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 22:50
 **/
public class FruitFactory {

    public IPhone createPhone(String type){

        if(type.equals("小米")){
            return new XiaoMi();
        }else if(type.equals("华为")){
            return new HuaWei();
        }else if(type.equals("红米")){
            return new HongMi();
        }

        return null;
    }

}
