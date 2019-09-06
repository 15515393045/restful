package com.car.admin.test32;

public interface IDrink {
    void runDrink();

    class DrinkMilk implements IDrink{

        @Override
        public void runDrink() {
            System.out.println("喝一杯牛奶");
        }
    }

    class DrinkCola implements IDrink{

        @Override
        public void runDrink() {
            System.out.println("喝一杯可乐");
        }
    }

}
