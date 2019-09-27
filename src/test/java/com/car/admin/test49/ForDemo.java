package com.car.admin.test49;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-26 09:34
 **/
public class ForDemo {

    public static void main(String[] args) {
        //int a = 10;
        //int b = a++-a--+a++;
        //System.out.println(b);


        int i = 6;//6
        System.out.println(i);
        int j =i--+i++;//11
        System.out.println(j);
        int m=++j-i--;
        System.out.println(m);

        int a = 6;//6
        String s = a>5?"√":"×";
        System.out.println(s);

        if(a > 5){
            String s1 = "√";
            System.out.println("a大于5"+s1);
        }else if(a < 10){
            String s1 = "×";
            System.out.println("a大于5但是小于10"+s1);
        }
}
}
