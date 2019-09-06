package com.car.admin.test27;

import com.car.admin.test27.impl.AudiCar;
import com.car.admin.test27.impl.ISimpleCarImpl;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 20:11
 **/
public class FactoryMethods {
    /** 
    * @Description: 多个方法工厂模式
    * @Param:  
    * @return:  
    * @Author: zhanyh
    * @Date: 2019/8/30 
    */ 
/*    public ISimpleCar getBWM(){
        return new ISimpleCarImpl();
    }

    public ISimpleCar getAudi(){
        return new AudiCar();
    }*/

/**
* @Description: 多个静态方法
* @Param: []
* @return: com.car.admin.test27.ISimpleCar
* @Author: zhanyh
* @Date: 2019/8/30
*/
    public static ISimpleCar getBWM(){
        return new ISimpleCarImpl();
    }

    public static ISimpleCar getAudi(){
        return new AudiCar();
    }
}
