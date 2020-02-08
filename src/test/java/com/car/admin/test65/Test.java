package com.car.admin.test65;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-08 14:37
 **/
public class Test {
/*    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        *//*
          与：&	有false则false
          或：|	有true则true
          异或：^ 相同则false,不同则true。(男女朋友)
          非：!	true则false,false则true
        *//*
        System.out.println((a > b) & (a > c));// false & false
        System.out.println((a < b) & (a > c)); // true & false
        System.out.println((a > b) & (a < c)); // false & true
        System.out.println((a < b) & (a < c)); // true & true
        System.out.println("---------------");
        System.out.println((a > b) | (a > c));// false | false
        System.out.println((a < b) | (a > c)); // true | false
        System.out.println((a > b) | (a < c)); // false | true
        System.out.println((a < b) | (a < c)); // true | true
        System.out.println("---------------");
        System.out.println((a > b) ^ (a > c));// false ^ false
        System.out.println((a < b) ^ (a > c)); // true ^ false
        System.out.println((a > b) ^ (a < c)); // false ^ true
        System.out.println((a < b) ^ (a < c)); // true ^ true
        System.out.println("---------------");
        System.out.println((a > b)); // false
        System.out.println(!(a > b)); // !false
        System.out.println(!!(a > b)); // !!false
    }*/



    /*public static void main(String[] args) {
        boolean aTrue = isString("false");
        System.out.println(aTrue);
        System.out.println(getType(aTrue));
    }*/

    //将字符串转换为布尔类型
    public static boolean isString(String str){
        if(Boolean.valueOf(str)){
            return true;
        }
        return false;
    }

    //获取参数类型
    public static String getType(Object o){   //获取变量类型方法
        return o.getClass().toString();      //使用Object类型的getClass()方法
    }

 /*   public static void main(String[] args) {
            int a = 10;
            int b = 20;
            int c = 30;
            *//*
             * &&和&的结果一样
             * ||和|的结果一样
             *
             * &&和&的区别：
             * 		&&如果左边是false，右边不执行。
             * 		&无论左边是true还是false，右边都会执行。
             *//*
            System.out.println((a > b) && (a > c));// false && false
            System.out.println((a < b) && (a > c)); // true && false
            System.out.println((a > b) && (a < c)); // false && true
            System.out.println((a < b) && (a < c)); // true && true
            System.out.println("---------------");
            System.out.println((a > b) || (a > c));// false || false
            System.out.println((a < b) || (a > c)); // true || false
            System.out.println((a > b) || (a < c)); // false || true
            System.out.println((a < b) || (a < c)); // true || true
            System.out.println("---------------");
        }
*/

/*    public static void main(String[] args) {
        // 定义三个int类型的变量
        int a = 10;
        int b = 30;
        int c = 20;

        // 先比较两个整数的大值
        int temp = ((a > b) ? a : b);
        int max = ((temp > c) ? temp : c);
        System.out.println("max:" + max);
        String str = "a";
        boolean equals = str.equals("a");
        System.out.println(equals);
    }*/

    public static void main(String[] args) {
    /* int i = 1;
     i = i++;
     int j = i;
     int k = i + ++i*i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);*/
/*
    int number1 = 12;
    int number2 = 5;

    int num = number1 / number2;
    System.out.println(num);//2

        double num1 = number1 / (number2 + 0.0);
        System.out.println(num1);//2.4

        double num2 = (double) number1 / number2;
        System.out.println(num2);//2.4

        double v = 5 + 0.0;
        System.out.println(v);

        double v1 = v / 6;
        System.out.println(v1);

        int number3 = 33223124;

        if(number3 % 2 == 0){
            System.out.println("整数");
        }else{
            System.out.println("奇数");
        }*/
        int num = 111;

        int ge = num % 10;

        int shi = num % 100 / 10;//num / 10 % 10;

        int bai = num / 100;

        System.out.println("个位：" + ge);
        System.out.println("十位：" + shi );
        System.out.println("百位：" + bai);
    }
}
