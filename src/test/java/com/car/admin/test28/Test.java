package com.car.admin.test28;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 21:01
 **/
public class Test {

    public static void main(String[] args) {
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        Cpu cpu = xiaoMiFactory.getCpu();
        cpu.run();
        Screen screen = xiaoMiFactory.getScreen();
        screen.size();


    }

}
