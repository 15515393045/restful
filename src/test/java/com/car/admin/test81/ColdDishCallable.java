package com.car.admin.test81;

import java.util.concurrent.Callable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 08:20
 **/
public class ColdDishCallable implements Callable {
    @Override
    public Object call() throws Exception {

        Thread.sleep(1000L);

        return "馒头出锅了";
    }
}
