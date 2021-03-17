package com.car.admin.test81;

import java.util.concurrent.Callable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 08:19
 **/
public class BumCallable implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000L);
        return "包子出锅了";
    }

}
