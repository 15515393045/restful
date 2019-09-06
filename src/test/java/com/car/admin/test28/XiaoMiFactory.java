package com.car.admin.test28;

import org.springframework.cglib.core.MethodWrapper;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 20:49
 **/
public class XiaoMiFactory implements PhoneFactory{


    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu650();//高效处理器
    }

    @Override
    public Screen getScreen() {
        return new Screen.screen5();//小屏手机
    }

}
