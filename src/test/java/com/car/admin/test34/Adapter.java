package com.car.admin.test34;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-04 11:40
 **/
public class Adapter extends Source implements Targer{
    @Override
    public void targerMethod() {
        System.out.println("没有适配器前输出5V");
        int i = this.sourceMethod();
        System.out.println("适配器之后输出"+i+"V");
    }
}
