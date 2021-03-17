package com.car.admin.test85;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 19:28
 **/
public class ParseAnnotation {

    /**
     * 解析方法注解
     *
     * @param clazz
     */
    public static <T> void parseMethod(Class<T> clazz) {
        try {
            T obj = clazz.newInstance();
            for (Method method : clazz.getDeclaredMethods()) {
                MyAnnotation.MyMethodAnnotation methodAnnotation = method.getAnnotation(MyAnnotation.MyMethodAnnotation.class);
                if (methodAnnotation != null) {
                    // 通过反射调用带有此注解的方法
                    method.invoke(obj, methodAnnotation.uri());
                }
                MyAnnotation.MyClassAndMethodAnnotation myClassAndMethodAnnotation = method
                        .getAnnotation(MyAnnotation.MyClassAndMethodAnnotation.class);
                if (myClassAndMethodAnnotation != null) {
                    if (MyAnnotation.MyClassAndMethodAnnotation.EnumType.util.equals(myClassAndMethodAnnotation.classType())) {
                        System.out.println("这是一个util方法");
                    } else {
                        System.out.println("这是另一种方法");
                    }
                    System.out.println(Arrays.toString(myClassAndMethodAnnotation.arr()));// 打印数组
                    System.out.println(myClassAndMethodAnnotation.color());// 输出颜色
                }
                System.out.println("\t\t-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void parseType(Class<T> clazz) {
        try {
            MyAnnotation.MyClassAndMethodAnnotation myClassAndMethodAnnotation = clazz
                    .getAnnotation(MyAnnotation.MyClassAndMethodAnnotation.class);
            if (myClassAndMethodAnnotation != null) {
                if (MyAnnotation.MyClassAndMethodAnnotation.EnumType.util.equals(myClassAndMethodAnnotation.classType())) {
                    System.out.println("这是一个util类");
                } else {
                    System.out.println("这是另一个类");
                }
            }
            MyAnnotation.MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyAnnotation.MyClassAnnotation.class);
            if (myClassAnnotation != null) {
                System.err.println(" 类信息: " + myClassAnnotation.uri());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        parseMethod(TestAnnotation.class);
        parseType(TestAnnotation.class);
    }

}
