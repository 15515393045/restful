package com.car.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateType {

    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String FULL_Y_M_D = "yyyy-MM-dd HH:mm:ss";


    public static String date2Str(Date date,String pattern){
        SimpleDateFormat sm = new SimpleDateFormat(pattern);
        if(date==null){
            return "";
        }
        String format = sm.format(date);
        return format;
    }

    public static  Date str2Date(String date,String pattern){
        SimpleDateFormat sm = new SimpleDateFormat(pattern);
        Date parse =null;
        try {
            parse = sm.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }


}
