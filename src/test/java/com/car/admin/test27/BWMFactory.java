package com.car.admin.test27;

import com.car.admin.test27.impl.ISimpleCarImpl;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 20:19
 **/
public class BWMFactory implements IFactory{

    @Override
    public ISimpleCar getCar() {
        return new ISimpleCarImpl();
    }
}
