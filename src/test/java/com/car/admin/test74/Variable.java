package com.car.admin.test74;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-07 18:16
 **/
public class Variable {



    public static void main(String[] args) {
    /* int[] arr = new int[4];
        arr[0] = 4;
        arr[1] = 3;
        arr[2] = 2;
        arr[3] = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
  */

  /*   double d = 0.5;
        System.out.println(Math.ceil(d));*/

        String s = new String("1,2,3,4,5");
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            System.out.println(s1);
        }


        //StringTokenizer(String str, String delim, boolean returnDelims)。returnDelims为true的话则delim分割符也被视为标记。
        StringTokenizer stringTokenizer = new StringTokenizer("www.ooobj.com", ".",true);
        /*
        在java.lang包中有String.split()方法，返回是一个数组。
        　1、“.”和“|”都是转义字符，必须得加"\\";
        　　如果用“.”作为分隔的话，必须是如下写法：
        String.split("\\."),这样才能正确的分隔开，不能用String.split(".");
            如果用“|”作为分隔的话，必须是如下写法：
        String.split("\\|"),这样才能正确的分隔开，不能用String.split("|");
        */
        while (stringTokenizer.hasMoreTokens()){
            System.out.println("令牌："+stringTokenizer.nextToken());
        }

        //long l = System.currentTimeMillis();
        //System.out.println(sdf.format(l));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));

    }

}
