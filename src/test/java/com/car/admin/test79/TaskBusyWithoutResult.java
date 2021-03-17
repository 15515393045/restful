package com.car.admin.test79;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 00:41
 **/
public class TaskBusyWithoutResult implements Runnable {

    public TaskBusyWithoutResult(){}

    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread()+"开始运行");
        int i = 100*100;
        while (i>0){
            i--;
            System.out.println("i值："+i);
        }
        System.out.println("线程"+Thread.currentThread()+"运行结束");
    }

}
