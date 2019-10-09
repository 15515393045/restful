package com.car.admin.test65;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-08 12:48
 **/
public class OperationalTest {
    //二进制 1 为true 0为false
    public static void main(String[] args) {
        int i = 12;//二进制为:0000000000000000000000000001100
        i <<= 2;//i左移2位，把高位的两位数字(左侧开始)抛弃,低位的空位补0,二进制码就为0000000000000000000000000110000
        System.out.println(i);//值为48；
        System.out.println(Integer.toBinaryString(i));//二进制110000
        i >>= 2;//i右移2位，把低位的两个数字(右侧开始)抛弃,高位整数补0，负数补1，二进制码就为0000000000000000000000000001100
        System.out.println(i); //值为12
        System.out.println(Integer.toBinaryString(i));//二进制码为1100

        //右移example
        int j = 11;//二进制码为00000000000000000000000000001011
        j >>= 2; //右移两位，抛弃最后两位,整数补0,二进制码为：00000000000000000000000000000010
        System.out.println(j); //值为2
        System.out.println(Integer.toBinaryString(j));//二进制码为10

        byte k = -2; //转为int,二进制码为：0000000000000000000000000000010
        k >>= 2; //右移2位，抛弃最后2位，负数补1,二进制码为：11000000000000000000000000000
        System.out.println(k); //值为-1
        System.out.println(Integer.toBinaryString(k));//二进制码为11

        int a = 1;
        int b = 1;
        //如果a和b有且仅有一个为true则返回true
        System.out.println(a^b);

        char a1 = 'a';
        System.out.println(10 + a1);
         a1 += 10;
        System.out.println(Integer.toBinaryString(a1));
        //    ~按位非（NOT）（一元运算） 对二进制进行取反
        int i2 = 42;
        System.out.println(Integer.toBinaryString(i2));
        int i3 = ~42;
        System.out.println(Integer.toBinaryString(i3));
    }

}









