package com.car.admin.test31;

import com.car.admin.test31.impl.FactoryHongMi;
import com.car.admin.test31.impl.FactoryHuaWei;
import com.car.admin.test31.impl.FactoryXiaoMi;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 22:52
 **/
public class MainTest {

    public static void main(String[] args) {

       FactoryPhone phone = new FactoryHuaWei();
        IPhone huawei = phone.createPhone();
        huawei.getPhone();
        
    }
}
