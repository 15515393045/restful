package com.car.admin.test57;

/**
 * @program: demo-restful
 * @description: 定义牧羊犬类
 *  牧羊犬属于犬科一种，让其继承犬科，获取的犬科的特性，
 *  由于牧羊犬具有放牧功能，那么它只要实现放牧接口即可，
 *  这样即保证牧羊犬具备犬科的特性，也拥有了放牧的功能。
 * @author: zhanyh
 * @create: 2019-09-29 15:36
 **/
public class Huntaway extends Canidae implements Graze{
    @Override
    void eat() {
        System.out.println("它正在吃饭");
    }

    @Override
    void sleep() {
        System.out.println("它正在睡觉");
    }

    @Override
    public void graze() {
        System.out.println("它正在放牧");
    }
}
