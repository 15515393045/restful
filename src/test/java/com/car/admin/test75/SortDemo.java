package com.car.admin.test75;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-09 23:14
 **/
public class SortDemo {

    public static void main(String[] args) {
        int size = 0;
        for (int i = 1; i < 20; i++) {
            if(i%2 == 0){
                System.out.println("进入判断的次数："+size++);
                continue;//结束当前循环进入下一次循环从表达式3开始。
            }
            System.out.println(i);
        }

        int sum = 0;

        for (int i = 2; i <= 100; i+=2) {
            sum = i+sum;
        }

        System.out.println(sum);
    }

}
