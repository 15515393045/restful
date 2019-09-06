package com.car.admin.test31.impl;

import com.car.admin.test31.FactoryPhone;
import com.car.admin.test31.HongMi;
import com.car.admin.test31.HuaWei;
import com.car.admin.test31.IPhone;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 23:23
 **/
public class FactoryHuaWei implements FactoryPhone {

    @Override
    public IPhone createPhone() {
        return new HuaWei();
    }

}
