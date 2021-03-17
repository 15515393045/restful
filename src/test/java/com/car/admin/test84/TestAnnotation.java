package com.car.admin.test84;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 18:12
 **/
//类
@Counter
public class TestAnnotation {

    //字段（域）
    //@Counter(number = 1314)
    private int age;

    //方法
    @Counter(number = 88)
    public void Demo(){

    }

    //构造器
    @Counter(number = 5201314)
    @MyConstructorAnnotation(uri = "暴富",desc = "发发发")
    public TestAnnotation(){}

    public static void main(String[] args) throws Exception {

        //Java反射获取类
        Class<TestAnnotation> testAnnotationClass = TestAnnotation.class;

        //通过Java反射获取TestAnnotation类中的Demo方法
        Method demo = testAnnotationClass.getMethod("Demo");
        if(demo.isAnnotationPresent(Counter.class)){
            //获取方法上面的注解
            Counter annotation = demo.getAnnotation(Counter.class);
            //获取自定义注解中值
            System.out.println(annotation.number());
        }else {
            System.out.println("Demo方法上没有自定义注解");
        }

        //判断类上是否有自定义注解
        if(testAnnotationClass.isAnnotationPresent(Counter.class)){
            //获取类上的注解
            Counter annotation1 = testAnnotationClass.getAnnotation(Counter.class);
            //获取自定义注解中值
            System.out.println(annotation1.number());
        }else{
            System.out.println("类上没有自定义注解。");
        }

        //获取字段注解(域)
        Field age = testAnnotationClass.getDeclaredField("age");// 暴力获取private修饰的成员变量
        //判断字段上有没有自定义注解
        if(age.isAnnotationPresent(Counter.class)){
            //获取字段上的自定义注解
            Counter annotation2 = age.getAnnotation(Counter.class);
            //获取自定义注解中值
            System.out.println(annotation2.number()+"："+annotation2.str());
        }else{
            System.out.println("该字段上上没有自定义注解！");
        }

        //获取构造函数上的自定注解
        Constructor<TestAnnotation> constructor = testAnnotationClass.getConstructor(new Class[]{});// 先获得构造方法对象
        //判断构造函数上有没有自定义注解
        if(constructor.isAnnotationPresent(Counter.class)){
            //拿到构造方法上面的注解实例
            Counter annotation3 = constructor.getAnnotation(Counter.class);
            //获取自定义注解中的值
            System.out.println(annotation3.number()+"==="+annotation3.str());
        }else{
            System.out.println("构造方法上没有自定义注解。");
        }
    }

}
