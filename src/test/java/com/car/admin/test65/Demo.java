package com.car.admin.test65;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-08 08:36
 **/
public class Demo {
    public static void main(String[] args) {
      /*  int[][] arr = {{1,2,3},{4,5,6}};
        int i = arr[0][2];
        System.out.println(i);
        int i1 = arr[1][1];
        System.out.println(i1);*/
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);
        System.out.println(calendar);
        boolean leapyear = isLeapyear(2020);
        //System.out.println(leapyear);

        // 使用默认时区和语言环境获得一个日历
        Calendar cal = Calendar.getInstance();
        // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2018, 0, 31, 8, 0, 0);
        System.out.println(sdf.format(cal1.getTime()));
        cal1.add(Calendar.MONTH, 1);
        System.out.println(sdf.format(cal1.getTime()));
        int i = 23>>>3;
        System.out.println(Integer.toBinaryString(i));//转换二进制
        System.out.println(Integer.toHexString(i));//转换十进制

        char[] arr = {'g','o','o','d','s'};
        String s = new String(arr,0,4);//包前不包后
        System.out.println(s);
        //String string = new String(arr,0,3);
    }

    /** 
    * @Description:  闰年：能被4整除，但不能被100整除，或能被100整除，又能被400整除。
    *  true: 闰年
    *  false：平年
    * @Param: [year] 
    * @return: boolean 
    * @Author: zhanyh 
    * @Date: 2019/10/8 
    */
    public static boolean isLeapyear(int year){
        return (year % 100 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}