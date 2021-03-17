package com.car.admin.test86;

import java.util.Scanner;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-21 21:43
 **/
public class IfStudy {

    public static void main(String[] args) {
       int number = (int) (Math.random()*90 + 10);
        //System.out.println(number);

        int numberShi = number/10;
        int numberGe = number%10;

        //2、用户输入一个两位数
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个两位数：");
        int guess = input.nextInt();//获取控制台输入的int类型的数字
        //System.out.println(guess);

        int guessShi = guess/10;
        int guessGe = guess%10;

        if(number == guess){
            System.out.println("奖金10 000美元");
        }else if(numberShi == guessGe && numberGe == guessShi){
            System.out.println("奖金3 000美元");
        }else if(numberShi==guessShi || numberGe == guessGe){
            System.out.println("奖金1 000美元");
        }else if(numberShi==guessGe || numberGe == guessShi){
            System.out.println("奖金500美元");
        }else{
            System.out.println("没中奖");
        }

        System.out.println("中奖号码是：" + number);

    }

}
