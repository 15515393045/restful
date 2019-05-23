package com.car.admin;

import com.car.admin.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {

        Date beginDate = new Date();

        String end = "2019-5-31";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = format.parse(end);


        //获取开始时间和结束时间之间相差多少天
        //System.out.println("获取开始时间和结束时间之间相差多少天："+DateUtils.getSubDays(beginDate,endDate));

        //判断是否是在同一天,true代表同一天,false代表不是同一天
        //System.out.println(DateUtils.isSameDate(beginDate,endDate));

        //获取开始日期和结束日期之间的分钟数
        //System.out.println("获取开始日期和结束日期之间的分钟数："+DateUtils.getSubMinutes(beginDate,endDate));

        //获取开始日期和结束日期之间的毫秒数
        //System.out.println("获取开始日期和结束日期之间的毫秒数："+DateUtils.getSubMsec(beginDate,endDate));

        //通过长整型计算持续时间
        //System.out.println(DateUtils.calculateDuration(80000000));

        //转换为中文日期表示
        //System.out.println(DateUtils.changeToLocalString(beginDate));

        //根据当前时间获取几天前的日期
        //System.out.println("当前时间两天前的时间："+DateUtils.getBeforeDate(2));

        //获取当前时间 小时
        //System.out.println("当前时间的小时："+DateUtils.currentHour());

        //获取当前分钟数
        //System.out.println("当前时间的分钟："+DateUtils.currentMinute());

        //该值根据log决定，当log以毫秒为单位时，flag=false时log以秒为单位，false=true时log以毫秒为单位
        //根据毫秒计算时分
        System.out.println(DateUtils.formatLongToTime(20190522140852014L,false));

        //返回经过了几小时几分钟
        System.out.println(DateUtils.formatLongToTime2(20190522140852014L,false));

        //返回精确到毫秒的当前时间
        System.out.println(DateUtils.getCurrentByYmdHmsSSS());

        //返回精确到秒的当前时间
        System.out.println(DateUtils.getCurrentByYmdHms());

        /**
         * 凌晨
         *
         * @param date
         * @flag 0 返回yyyy-MM-dd 00:00:00日期<br>
         *       1 返回yyyy-MM-dd 23:59:59日期
         * @return
         */
        System.out.println(DateUtils.weeHours(beginDate,1));

        //获取当天最早时间
        Date startTime = DateUtils.getStartTime();
        System.out.println(startTime);

        //获取当天最晚时间
        System.out.println(DateUtils.getEndTime());

        //判断一个日期是否是周末
        System.out.println(DateUtils.ifWeekend(new Date()));
    }

}
