package com.car.admin.test5;

public class CountDemo implements Runnable{


    private static int i = 0;

    @Override
    public void run() {
        count();
    }

    public synchronized void count(){
        i++;
        System.out.println(i);
    }
}
