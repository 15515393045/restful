package com.car.admin.test32;

public interface IEat {
    void runEat();

    class EatBread implements  IEat{

        @Override
        public void runEat() {
            System.out.println("吃了一个面包");
        }
    }

    class EatHamburger implements IEat{

        @Override
        public void runEat() {
            System.out.println("吃了一个汉堡");
        }
    }

}
