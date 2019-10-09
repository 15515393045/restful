package com.car.admin.test57;

/**
 * @program: demo-restful
 * @description: 定义子类去覆盖接口中的方法。类与接口之间的关系是 实现。通过 关键字 implements
 * @author: zhanyh
 * @create: 2019-09-29 15:16
 **/
public class DemoImpl implements Demo{//子类实现Demo接口。
    //重写接口中的方法。
    @Override
    public void show1() {
        int num = NUM;//3
    }

    @Override
    public void show2() {
        int num = NUM;//3
    }
}
