package com.car.admin.test76;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-12 21:26
 **/
public class Demo {

 /*    public static void main(String[] args) {
        int i = 1;//1  2   4
        i = i++;//1  2
        int j = i++;//1
        int k = i + ++i*i++;//11
         System.out.println("i==="+i);
         System.out.println("j==="+j);
         System.out.println("k==="+k);

    }*/

    public static void main(String[] args) {
    /*    int a = 2;
        int b = (3 * a++) + a;
        System.out.println(b);//9*/

       /* int a = 2;
        int b = a + (3 * a++);
        System.out.println(b);//8*/

      /*  int i = 1;
        int j = 1;
        int k = i++ + ++i + ++j + j++;
        System.out.println(k);//8*/

        int a = 0;
        int b = 0;
        a = a++;//1
        b = a++;//0
        System.out.println("a = " + a + ", b = " + b);

        boolean b1 = true;
        int i = 0;
        if (b1){//一个变量也是表达式，多个表达式的加减法运算都是从左到右进行的，乘除除外。
            i++;
        }
        System.out.println(i+"    ===============");
    }


}
