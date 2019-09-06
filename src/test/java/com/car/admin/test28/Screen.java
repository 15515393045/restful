package com.car.admin.test28;

import com.car.admin.test23.ImgCodeDemo;

public interface Screen {
    void size();

    class screen5 implements Screen{

        @Override
        public void size() {
            System.out.println("五寸大屏幕");
        }
    }

    class screen6 implements Screen{

        @Override
        public void size() {
            System.out.println("六寸大屏幕");
        }
    }
}
