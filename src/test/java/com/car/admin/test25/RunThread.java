package com.car.admin.test25;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-29 21:29
 **/
public class RunThread {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        for (int i =0; i < 1000 ; i++) {

            Thread thread = new Thread(threadDemo);

            thread.start();

        }
    }

}
