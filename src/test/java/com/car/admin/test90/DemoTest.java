package com.car.admin.test90;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-06-09 11:37
 **/
public class DemoTest {

   /* public static void main(String[] args){

       List<String> list = new ArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王五");
       *//*  for (String s : list) {
            if(s.equals("李四")){
                list.remove(s);
            }
        }
        System.out.println(list);*//*

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("王五")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }*/

   /* public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当前月份：");
        int month = scanner.nextInt();
        System.out.println("请输入当前日期：");
        int day = scanner.nextInt();

        int sumDay = 0;

        switch (month){
            case 12:
                sumDay += 31;
            case 11:
                sumDay += 30;
            case 10:
                sumDay += 31;
            case 9:
                sumDay += 30;
            case 8:
                sumDay += 31;
            case 7:
                sumDay += 31;
            case 6:
                sumDay += 30;
            case 5:
                sumDay += 31;
            case 4:
                sumDay += 30;
            case 3:
                sumDay += 31;
            case 2:
                sumDay += 28;
            case 1:
                sumDay += day;
        }

        System.out.println("2020年"+month+"月"+day+"日是当年的第"+sumDay+"天！");

    }*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入year：");
        int year = scanner.nextInt();
        System.out.println("请输入month：");
        int month = scanner.nextInt();
        System.out.println("请输入day：");
        int day = scanner.nextInt();

        int sumDay = 0;

        switch (month){
            case 12:
                sumDay += 31;
            case 11:
                sumDay += 30;
            case 10:
                sumDay += 31;
            case 9:
                sumDay += 30;
            case 8:
                sumDay += 31;
            case 7:
                sumDay += 31;
            case 6:
                sumDay += 30;
            case 5:
                sumDay += 31;
            case 4:
                sumDay += 30;
            case 3:
                //sumDay += 31;
                //判断是否是闰年，可以被4整除不能被100整除，可以被400整除
                if((year % 4 == 0 && year % 100 !=0)||year % 400 == 0){
                    sumDay += 29;//闰年
                }else{
                    sumDay += 28;//平年
                }
            case 2:
                sumDay += 28;
            case 1:
                sumDay += day;
        }

        System.out.println(year+"年"+month+"月"+day+"日是当年的第"+sumDay+"天！");

        //定义结果集
        int sum = 0;

        for (int i = 2; i <= 100; i+=2) {
            sum = sum + i;//sum+=i
        }

        System.out.println(sum);

        System.out.println("\n");

        for(int i=1;i<=9;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(j+"*"+i+"="+(j*i)+" ");
                }
            System.out.println();
        }

    }

}
