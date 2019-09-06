package com.car.admin.test31.impl;

import com.car.admin.test31.FactoryPhone;
import com.car.admin.test31.IPhone;
import com.car.admin.test31.XiaoMi;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 23:20
 **/
public class FactoryXiaoMi implements FactoryPhone {

    @Override
    public IPhone createPhone() {
        return new XiaoMi();
    }

}
