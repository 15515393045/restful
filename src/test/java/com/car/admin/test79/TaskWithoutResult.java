package com.car.admin.test79;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 00:17
 **/
public class TaskWithoutResult implements Runnable{

    private int sleepTime=1000;//默认睡眠时间1s
    //收到声明有参构造函数
    public TaskWithoutResult(int sleepTime){
        this.sleepTime = sleepTime;
    }
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread()+"开始运行");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {//捕捉中断异常
            System.out.println("线程"+Thread.currentThread()+"被中断");
           // System.out.println(e.getMessage());
        }
        System.out.println("线程"+Thread.currentThread()+"结束运行");
    }

}
