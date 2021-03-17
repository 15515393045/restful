package com.car.admin.test82;

import java.util.concurrent.Callable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 08:51
 **/
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(3000);//模拟耗时任务3s
        System.out.println("MyCallable 线程：" + Thread.currentThread().getName());
        return "返回值：MyCallable 线程";
    }
}
