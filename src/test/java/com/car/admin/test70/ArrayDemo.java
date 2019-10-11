package com.car.admin.test70;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-10 17:37
 **/
public class ArrayDemo {

    public static void main(String[] args) {
        int s[];
        s = new int[10];
        //int[] s=new int[10];
        //基本数据类型数组在显式赋值之前,
        //Java会自动给他们赋默认值。
        for(int i=0;i<10;i++){
           s[i] = 2*i+1;
            System.out.println(s[i]);
        }

    }

}
