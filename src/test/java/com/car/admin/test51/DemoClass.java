package com.car.admin.test51;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-27 16:15
 **/
@MyContainerAnnotations({
        @RepeatUseAnnotations(user = "王五", password = "789"),
        @RepeatUseAnnotations(user = "赵六", password = "101")
})
public class DemoClass {

    @RepeatUseAnnotations(user = "张三", password = "123")
    @RepeatUseAnnotations(user = "李四", password = "456")
    public void test(){}

/*
    public static void main(String[] args) throws NoSuchMethodException {
        //获取方法上的自定义重复注解
        Method test = DemoClass.class.getMethod("test");
        //通过方法获取自定义容器注解
        MyContainerAnnotations annotation2 = test.getAnnotation(MyContainerAnnotations.class);
        //调用它里面的value();方法获取重复使用注解的数组
        RepeatUseAnnotations[] value = annotation2.value();
        //遍历循环进行取值
        for (RepeatUseAnnotations repeatUseAnnotations : value) {
            String user = repeatUseAnnotations.user();
            String password = repeatUseAnnotations.password();
            System.out.println(user+"："+password);
        }

        //判断类上有没有自定义注解
        if(DemoClass.class.isAnnotationPresent(MyContainerAnnotations.class)){
            //获取类上的自定义容器注解
            MyContainerAnnotations annotation = DemoClass.class.getAnnotation(MyContainerAnnotations.class);
            //循环遍历重复使用的注解 annotation.value()  方法获取的就是容器注解里面的一个个重复使用的注解。
            for (RepeatUseAnnotations annotation1 : annotation.value()) {
                //取值
                String password = annotation1.password();
                String user = annotation1.user();
                //打印输出
                System.out.println(user+"："+password);
            }
        }
    }
*/


    @Test
    public void test1() throws NoSuchMethodException {
        //获取方法上的自定义注解
        Method test = this.getClass().getMethod("test");
        //通过方法调用注解数组方法
        Annotation[] annotations = test.getAnnotations();
        for (Annotation annotation : annotations) {
            //将其转换为容器注解
            MyContainerAnnotations annotation1 = (MyContainerAnnotations) annotation;
            //调用容器注解类中的方法获取重复注解数组
            RepeatUseAnnotations[] value = annotation1.value();
            //遍历循环进行取值
            for (RepeatUseAnnotations repeatUseAnnotations : value) {
                String user = repeatUseAnnotations.user();
                String password = repeatUseAnnotations.password();
                System.out.println(user+"："+password);
            }
        }

        //获取类上的自定义注解
        if(this.getClass().isAnnotationPresent(MyContainerAnnotations.class)){
            //获取类上的注解数组
            Annotation[] annotations1 = this.getClass().getAnnotations();
            for (int i = 0; i < annotations1.length; i++) {
                //将其里面的元素强制转换位容器数组
                MyContainerAnnotations annotation = (MyContainerAnnotations) annotations1[i];
                //调用容器数组的方法获取，重复注解的数组
                RepeatUseAnnotations[] value = annotation.value();
                //循环取值
                for (int j = 0; j < value.length; j++) {
                    RepeatUseAnnotations repeatUseAnnotations = value[j];
                    String user = repeatUseAnnotations.user();
                    String password = repeatUseAnnotations.password();
                    System.out.println(user+"："+password);
                }
            }
        }
    }

}




