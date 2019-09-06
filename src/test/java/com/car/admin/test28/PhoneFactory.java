package com.car.admin.test28;

/** 
* @Description: 工厂接口
* @Param:  
* @return:  
* @Author: zhanyh
* @Date: 2019/8/30 
*/ 
public interface PhoneFactory {

    Cpu getCpu();//使用的cpu

    Screen getScreen();//使用的屏幕

}
