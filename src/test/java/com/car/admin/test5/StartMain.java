package com.car.admin.test5;

public class StartMain {

    public static void main(String[] args) {
        CountDemo demo = new CountDemo();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(demo);
            thread.start();
        }
    }

}
