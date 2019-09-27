package com.car.admin.test52;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-27 18:01
 **/
public class JavaReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.car.admin.test52.Person");
        //获得类的完整名字。
        String name = aClass.getName();
        System.out.println(name);
        //获得类的public类型的属性。
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        //获得类的所有属性。包括private 声明的和继承类
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        //获得类的public类型的方法。
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        //获得类的所有方法。包括private 声明的和继承类
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        //getMethod(String name, Class[] parameterTypes)：获得类的特定方法，
        // name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
        Method eat = aClass.getMethod("eat", null);
        System.out.println(eat.getName());
        //获得类的public类型的构造方法。
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        //获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor.getName());
        //通过类的不带参数的构造方法创建这个类的一个对象。
        Object o = aClass.newInstance();
        System.out.println(o.toString());
    }

}
