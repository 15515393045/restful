package com.car.admin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @description 注意：请勿自行创建 SimpleDateFormat对象
 * @date
 */
public class DateUtils {

    public final static String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    public final static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_FORMAT_1 = "yyyy-MM-dd";

    public final static String TIME_FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";

    public final static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public final static String YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public final static String MM_DD_HH = "MM月dd日HH点";

    public final static DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

    /** 年月日时分秒格式化 **/
    private static final ThreadLocal<SimpleDateFormat> fmt_YMDHMS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /** 年月日格式化 **/
    private static final ThreadLocal<SimpleDateFormat> fmt_YMD = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /** 时分秒格式化 **/
    private static final ThreadLocal<SimpleDateFormat> fmt_HMS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };

    /** 时分格式化 **/
    private static final ThreadLocal<SimpleDateFormat> fmt_HM = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm");
        }
    };

    /** 时分格式化 **/
    private static final ThreadLocal<SimpleDateFormat> fmt_MD = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM月dd日");
        }
    };

    /** 年月日时分秒毫秒格式化 **/
    private static final ThreadLocal<SimpleDateFormat> fmt_YMDHMSS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
    };

    /**
     * 声明的日期字段
     *
     * @author gexu
     *
     */
    public static enum DateFiled {
        Date_MilliSecond(Calendar.MILLISECOND), Date_Second(Calendar.SECOND), Date_Minute(
                Calendar.MINUTE), Date_Hour_OF_Day(Calendar.HOUR_OF_DAY), Date_Day(
                Calendar.DAY_OF_MONTH), Date_Month(Calendar.MONTH), Date_Year(Calendar.YEAR);

        public final int field;

        DateFiled(int field) {
            this.field = field;
        }
    }

    public static Date todayWithOutTime() {
        return truncDate(new Date());
    }

    /**
     * 截断日期，保留到日期
     *
     * @param date
     */
    public static Date truncDate(Date date) {
        return truncDate(date, DateFiled.Date_Day);
    }

    /**
     * 按照指定字段进行日期截断操作，保留到指定的字段
     *
     * @param date
     * @param field
     */
    public static Date truncDate(Date date, DateFiled field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 按照声明顺序进行迭代
        for (DateFiled f : DateFiled.values()) {
            if (f == field) {
                break;
            }
            cal.set(f.field, 0);
        }
        date.setTime(cal.getTimeInMillis());
        return date;
    }

    /**
     * 日期计算，通过Calendar处理
     *
     * @param original
     * @param calendarFieldType
     * @param amount
     * @return
     */
    public static Date add(Date original, int calendarFieldType, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(original);
        cal.add(calendarFieldType, amount);
        return cal.getTime();
    }

    public static String formatCurrentDate(String fmt) {
        return formatDate(new Date(), fmt);
    }

    public static Calendar getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal;
    }

    public static String formatDate(Calendar calendar, String fmt) {
        return formatDate(calendar.getTime(), fmt);
    }

    public static String formatDate(Date date, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(date);
    }

    public static Date parseDate(String fmt, String dateStr) {
        return parseDate(fmt, dateStr, null);
    }

    public static Date parseDate(String fmt, String dateStr, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(fmt, locale);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("分析时间日期字符串异常,fmt[%s],locale[%s],dateStr[%s]", fmt, locale, dateStr), e);
        }
    }

    public static java.sql.Date changeToSQLDate(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static java.sql.Date changeToSQLDate(String source, String format) {
        return new java.sql.Date(parseDate(format, source).getTime());
    }

    public static java.sql.Timestamp changeToSQLTimestamp(String source, String format) {
        return new java.sql.Timestamp(parseDate(format, source).getTime());
    }

    public static java.sql.Timestamp changeToSQLTimestamp(Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    /**     开始日期   结束日期
     * 获取endDate与beginDate之间的天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getSubDays(Date beginDate, Date endDate) {
        long times = endDate.getTime() - beginDate.getTime();
        return (int) (times / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取endDate与beginDate之间的分钟数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getSubMinutes(Date beginDate, Date endDate) {
        long times = endDate.getTime() - beginDate.getTime();
        return (int) (times / (1000 * 60));
    }

    /**
     * 获取endDate与beginDate之间的毫秒数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long getSubMsec(Date beginDate, Date endDate) {
        long times = 0L;
        if (beginDate != null && endDate != null) {
            times = endDate.getTime() - beginDate.getTime();
        }
        return times;
    }

    /**
     * 获取endDate与beginDate之间时间差
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String getSubTime(Date beginDate, Date endDate) {
        long times = endDate.getTime() - beginDate.getTime();
        int hh = (int) times / (1000 * 60 * 60);
        int mm = (int) times % (1000 * 60 * 60) / (1000 * 60);
        int ss = (int) times % (1000 * 60 * 60) % (1000 * 60) / 1000;
        if (hh < 10 && mm < 10 && ss < 10){
            return  "0" + hh  + ":" + "0" + mm + ":" + "0" + ss;
        }else if (hh < 10 && mm < 10){
            return  "0" + hh  + ":" + "0" + mm + ":"  + ss;
        }else if (hh < 10 && ss < 10){
            return  "0" + hh  + ":" + mm + ":" + "0" + ss;
        }else if (mm < 10 && ss < 10){
            return   hh  + ":" + mm + ":" + "0" + ss;
        }else if (hh < 10){
            return  "0" +  hh  + ":" + mm + ":"  + ss;
        }else if (mm < 10){
            return   hh  + ":" + "0" + mm + ":"  + ss;
        }else if (ss < 10){
            return   hh  + ":" + mm + ":" + "0" + ss;
        }
        else{
            return  hh + ":" + mm + ":" + ss;
        }
    }

    /**
     * 通过长整型计算持续时间
     *
     * @param duration
     * @return
     */
    public static String calculateDuration(long duration) {
        StringBuilder dur = new StringBuilder();

        dur.insert(0, duration % 1000 + "毫秒");
        duration = duration / 1000;
        if (duration <= 0) {
            return dur.toString();
        }

        dur.insert(0, duration % 60 + "秒");
        duration = duration / 60;
        if (duration <= 0) {
            return dur.toString();
        }

        dur.insert(0, duration % 60 + "分");
        duration = duration / 60;
        if (duration <= 0) {
            return dur.toString();
        }

        dur.insert(0, duration + "小时");
        return dur.toString();
    }

    /**
     * 转换为中文日期表示
     *
     * @param date
     * @return
     */
    public static String changeToLocalString(Date date) {
        return df.format(date);
    }

    /**
     * 获得几天前的日期
     *
     * @param days
     * @return
     */
    public static String getBeforeDate(Integer days) {
        return formatDate(new Date(System.currentTimeMillis() - days * 24 * 60 * 60 * 1000L), "yyyy-MM-dd");
    }

    /**
     * 获得几天前的日期
     *
     * @param days
     * @return
     */
    public static String getBeforeDates(Integer days) {
        return formatDate(new Date(System.currentTimeMillis() - days * 24 * 60 * 60 * 1000L), "yyyy_MM_dd");
    }

    /**
     * 获得几天前的日期
     *
     * @param days
     * @param formate
     * @return
     */
    public static String getBeforeDay(Integer days, String formate) {
        return formatDate(new Date(System.currentTimeMillis() - days * 24 * 60 * 60 * 1000L), formate);
        // return formatDate(new Date(System.currentTimeMillis()), formate);
    }

    /**
     * 获取当前时间 小时
     *
     * @return
     */
    public static int currentHour() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前分钟数
     *
     * @return
     */
    public static int currentMinute() {
        Calendar calendar = Calendar.getInstance();
        int minute = calendar.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * 根据毫秒数计算时分
     *
     * @param log
     * @param flag
     * @return 该值根据log决定，当log以毫秒为单位时，flag=false,当log以秒为单位，false=true
     */
    public static String formatLongToTime(Long log, boolean flag) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (!flag) {
            second = log.intValue() / 1000;
        } else {
            second = log.intValue();
        }
        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        return (getTwoLength(hour) + ":" + getTwoLength(minute));
    }

    public static String getTwoLength(final int data) {
        if (data < 10) {
            return "0" + data;
        } else {
            return "" + data;
        }
    }

    /**
     * 返回经过了几小时几分钟
     * @param log
     * @param flag
     * @return
     */
    public static String formatLongToTime2(Long log, boolean flag) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (!flag) {
            second = log.intValue() / 1000;
        } else {
            second = log.intValue();
        }
        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        if(hour == 0){
            return (minute + "分钟");
        } else {
            return (hour + "小时" + minute + "分钟" + second);
        }
    }

    /**
     * 格式化日期 时分秒
     *
     * @param date
     * @return String
     */
    public static String getStrByHms(Date date) {
        return fmt_HMS.get().format(date);
    }

    /**
     * 格式化日期 时分
     *
     * @param date
     * @return String
     */
    public static String getStrByHm(String date) {
        return fmt_HM.get().format(date);
    }

    /**
     * 格式化日期 月 日
     *
     * @param date
     * @return String
     */
    public static String getStrByMd(Date date) {
        return fmt_MD.get().format(date);
    }

    /**
     * 格式化日期 年 月 日
     *
     * @param date
     * @return
     */
    public static String getStrByYmd(Date date) {
        return fmt_YMD.get().format(date);
    }

    /**
     * 格式化日期 时分
     *
     * @param date
     * @return String
     */
    public static String getStrByHm(Date date) {
        return fmt_HM.get().format(date);
    }

    /**
     * 格式化日期 时分秒
     *
     * @param date
     * @return String
     * @throws ParseException
     */
    public static Date getDateByHms(String date) throws ParseException {
        return fmt_HMS.get().parse(date);
    }

    /**
     * 格式化日期 时分
     *
     * @param date
     * @return String
     * @throws ParseException
     */
    public static Date getDateByHm(Date date) throws ParseException {
        return fmt_HM.get().parse(fmt_HM.get().format(date));
    }

    /**
     * 返回精确到毫秒的当前时间
     *
     * @return
     */
    public static String getCurrentByYmdHmsSSS() {
        return fmt_YMDHMSS.get().format(new Date());
    }

    /**
     * 返回精确到秒的当前时间
     *
     * @return
     */
    public static String getCurrentByYmdHms() {
        return fmt_YMDHMS.get().format(new Date());
    }

    /**
     * 返回精确到天的当前时间
     *
     * @return
     */
    public static String getCurrentByYmd() {
        return fmt_YMD.get().format(new Date());
    }

    /**
     * 返回精确到秒的当前时间
     *
     * @return
     */
    public static String getCurrentByYmdHms(Date date) {
        return fmt_YMDHMS.get().format(date);
    }

    /**
     * 凌晨
     *
     * @param date
     * @flag 0 返回yyyy-MM-dd 00:00:00日期<br>
     *       1 返回yyyy-MM-dd 23:59:59日期
     * @return
     */
    public static Date weeHours(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        // 时分秒（毫秒数）
        long millisecond = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000;
        // 凌晨00:00:00
        cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);

        if (flag == 0) {
            return cal.getTime();
        } else if (flag == 1) {
            // 凌晨23:59:59
            cal.setTimeInMillis(cal.getTimeInMillis() + 23 * 60 * 60 * 1000 + 59 * 60 * 1000 + 59 * 1000);
        }
        return cal.getTime();
    }

    /**
     * long to String
     *
     * @param lng
     * @return HH:MM 格式
     * @param
     */
    public static String longToString(Long lng) {
        Date date = new Date(lng);
        return fmt_HM.get().format(date);
    }

    /**
     * long时间
     *
     * @return
     */
    public static Long getAssignTime(int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE, day);
        calendar.set(calendar.HOUR, hour);
        calendar.set(calendar.MINUTE, minute);
        calendar.set(calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * long时间
     *
     * @param date
     * @param num
     * @return
     */
    public static String longToStrByHHmm(Long date, int num) {
        int hour = 0;
        int minute = 0;
        hour = (int) (date / num);
        minute = (int) (date % num) + 1;
        return hour + " 小时 " + minute + " 分";
    }

    /**
     *
     * @param date
     * @return
     */
    public static Boolean isToday(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        // 格式化为相同格式
        if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当天最早时间
     * @return
     */
    public static Date getStartTime() {
        try{
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            Date d = c.getTime();
            return f.parse(f.format(d));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当天最晚时间
     * @return
     */
    public static Date getEndTime() {
        try{
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar todayEnd = Calendar.getInstance();
            todayEnd.set(Calendar.HOUR_OF_DAY, 23);
            todayEnd.set(Calendar.MINUTE, 59);
            todayEnd.set(Calendar.SECOND, 59);
            Date d = todayEnd.getTime();
            return f.parse(f.format(d));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Date lastMonthDate(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    /**
     * 判断一个日期是否是周末
     * @return
     */
    public static boolean ifWeekend(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
            return true;
        }
        return false;
    }

    /**
     * 获取当前日期是星期几
     * @param date
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 判断两个时间是否是同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    public static Date dateFormat(Date date,String format){
        try{
            Date formatDate;
            SimpleDateFormat sdf=new SimpleDateFormat(format);
            String dateString = sdf.format(date);
            formatDate = sdf.parse(dateString);
            return formatDate;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 日期格式化并转换成指定格式的String字符
     * @param date
     * @param format
     * @return
     */
    public static String dateFormatString(Date date,String format){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat(format);
            return sdf.format(date);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到毫秒的字符串
     * @return
     */
    public static Date timeStamp2Date(String seconds) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String val = sdf.format(Long.parseLong(seconds));
        Date date = null;
        try {
            date = sdf.parse(val);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 通过两个时间算出相关
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String getDatePoor(Date beginDate, Date endDate) {
        StringBuffer sb = new StringBuffer();
        long nd = 1000 * 24 * 60 * 60;//每天毫秒数
        long nh = 1000 * 60 * 60;//每小时毫秒数
        long nm = 1000 * 60;//每分钟毫秒数
        long diff = endDate.getTime() - beginDate.getTime(); // 获得两个时间的毫秒时间差异
        long day = diff / nd;   // 计算差多少天
        if(day > 0){
            sb.append(day+"天");
        }
        long hour = diff % nd / nh; // 计算差多少小时
        if(hour > 0){
            sb.append(hour+"小时");
        }
        long min = diff % nd % nh / nm;  // 计算差多少分钟
        if(min > 0){
            sb.append(min+"分钟");
        }
        return sb.toString();

    }

    public static void main(String[] args) throws InterruptedException {
//        Date date1 = new Date();
//        System.out.println(date1);
//        Date date2 = DateUtils.add(date1, Calendar.MINUTE, 23);
//        System.out.println(date2);
//        String timeStr = DateUtils.formatLongToTime2(date2.getTime()-date1.getTime(), false);
        try{
            String format = "yyyy-MM-dd HH:mm:ss";
//            Date nowTime = new SimpleDateFormat(format).parse("2019-04-17 09:27:00");
            Date startTime = new SimpleDateFormat(format).parse("2019-04-28 10:15:00");
            Date endTime = new SimpleDateFormat(format).parse("2019-04-28 12:00:00");
            System.out.println(endTime.getTime()+"=="+startTime.getTime());
//            int a = Math.abs(getSubMinutes(startTime,endTime));
//            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
