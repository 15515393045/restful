package com.car.admin.test28;

public interface Cpu {

    void run();

    class Cpu650 implements Cpu{

        @Override
        public void run() {
            System.out.println("Cpu650"+666);
        }
    }

    class Cpu850 implements Cpu{

        @Override
        public void run() {
            System.out.println("Cpu850牛逼");
        }
    }
}
