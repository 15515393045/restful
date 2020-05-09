package com.car.admin.test75;

/**
 * @program: demo-restful
 * @description: 无论创建多少个实例对象
 * （VariantTest variantTest1 = new VariantTest();）
 *  永远都值分配一个 staticVar 变量。并且每创建一个实例对象，
 *  这个 staticVar 类变量就会加1; 但是每创建一个实例对象就会
 *  分配一个 instanceVar ,即可能分配多个 instanceVar, 并且每个
 *   instanceVar 的值都加了一次。
 * @author: zhanyh
 * @create: 2020-05-09 20:40
 **/
public class VariantTest {

    public static int staticVar = 0;//类变量,位于方法区

    public int instanceVar = 0;//实例变量,位于堆内存

    public VariantTest(){
        staticVar++;
        instanceVar++;
        //类被调用几次就会有几个类变量
        System.out.println("静态成员变量："+staticVar);
        //因实例变量所存在堆空间中，其内存地址不一样引用所指向的指也不是同一个,
        // 所以每次都是1,除非该实例的引用指向同一个空间。
        System.out.println("实例成员变量："+instanceVar);
    }




}
