package com.car.admin.test62;

import com.car.admin.test56.Employee;
import javafx.util.Pair;
import org.apache.catalina.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description: 通配符
 * @author: zhanyh
 * @create: 2019-09-30 16:06
 **/
public class WildcardTest {


    /*public static void main(String[] args) {


        firstPrint();
        secondPrint();
    }

    public static void firstPrint() {
        List<Float> list1 = new ArrayList<>();//使用 Float作实参类型
        list1.add(12.3f);
        list1.add(23.4f);
        print(list1);
    }

    public static void secondPrint() {
        List<Integer> list2 = new ArrayList<>();//使用Integer作实参类型
        list2.add(1);
        list2.add(2);
        list2.add(3);
        print(list2);
    }

    public static void print(List<? extends Number> list) {// 通配符作形参
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));// 使用get方法
        }
    }*/
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        firstInflate(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.clear();//清空List集合
        secondInflate(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    public static void firstInflate(List<? super Integer> list) {// 装填整数
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void secondInflate(List<? super Float> list) {// 装填浮点数
        list.add(1.1f);
        list.add(2.2f);
        list.add(1.3f);
    }

}
