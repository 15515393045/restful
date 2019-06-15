package com.car.admin.thread;

/**
 * @program: demo-restful
 * @description: 测试
 * @author: zhanyh
 * @create: 2019-06-01 15:47
 **/
public class testThread {

    public static void main(String[] args) {

        DemoThread thread = new DemoThread();
        for (int i = 0; i < 5000; i++) {
            Thread thread1 = new Thread(thread);
            thread1.start();
        }

    }

}
