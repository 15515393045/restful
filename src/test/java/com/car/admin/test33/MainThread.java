package com.car.admin.test33;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-02 22:41
 **/
public class MainThread {

    public static void main(String[] args) {
        System.out.println("第一步");
        ThreadTest threadTest = new ThreadTest();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(threadTest);
            thread.start();
        }



        System.out.println("最后一步");
    }

}
