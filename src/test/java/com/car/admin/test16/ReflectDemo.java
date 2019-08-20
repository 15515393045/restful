package com.car.admin.test16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: demo-restful
 * @description:反射
 * @author: zhanyh
 * @create: 2019-08-19 11:16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectDemo {

    @Test
   public void test(){

        CarBean carBean = new CarBean();

        Class carBeanClass = carBean.getClass();
        //获取到对象中的所有属性
        Field[] fields = carBeanClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            //System.out.println(field.getName());
        }

        //获取对象中的公共属性
        Field[] publicFields = carBeanClass.getFields();
        for (Field publicField : publicFields) {
            //System.out.println(publicField);
        }

        //获取所有的方法
        Method[] methods = carBeanClass.getDeclaredMethods();
        for (Method method : methods) {
            //获取所有方法的返回值类型
            //System.out.println(method.getReturnType());
            //获取所有方法的名称
            //System.out.println(method.getName());
        }

        //获取所有的公共方法  public修饰的 包括父类
        Method[] methods1 = carBeanClass.getMethods();
        for (Method method : methods1) {
            //System.out.println(method.getName());
        }

        //获取无参的构造函数
        Constructor[] constructors = carBeanClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
           // System.out.println(constructor);
        }

        String className = "com.car.admin.test16.CarBean";

        try {
            Class<?> forName = Class.forName(className);
            //通过无参构造函数获取到TestVo
            CarBean carBean1 = (CarBean) forName.getConstructor().newInstance();
            carBean1.setCarName("保时捷");
            System.out.println(carBean1.getCarName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
