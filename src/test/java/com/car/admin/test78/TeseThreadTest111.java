package com.car.admin.test78;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-18 22:56
 **/
public class TeseThreadTest111 {

    public static void main(String[] args) {
        ThreadTest111 target = new ThreadTest111();
        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread(target);
            thread.start();
        }
    }

}
