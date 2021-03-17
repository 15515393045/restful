package com.car.admin.test87;

import java.util.Scanner;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-21 22:36
 **/
public class GuessNumber {

    public static void main(String[] args) {
        //1、产生一个[1-6]的数
        int a = (int)(Math.random()*6+1);
        //System.out.println(a);
        int b = (int)(Math.random()*6+1);
        //System.out.println(b);
        int c = (int)(Math.random()*6+1);
        //System.out.println(c);

		/*
		a = 1;
		b = 1;
		c = 1;
		*/

        String result = "";
        if(a==b && b==c){
            result = "豹子";
        }else if(a+b+c <=9 ){
            result = "小";
        }else{
            result = "大";
        }

        //2、用户输入猜的结果
        Scanner input = new Scanner(System.in);
        System.out.print("请押宝，买定离手：(选择：大、小、豹子)");
        String guess = input.next();

        System.out.println("骰子一："+a);
        System.out.println("骰子二："+b);
        System.out.println("骰子三："+c);

        System.out.println("三个骰子的合："+(a+b+c));

        //3、判断结果
        if(result.equals(guess)){
            System.out.println("猜对了");
        }else{
            System.out.println("猜错了");
        }

    }

}
