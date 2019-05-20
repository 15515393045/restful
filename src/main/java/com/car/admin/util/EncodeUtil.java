package com.car.admin.util;



import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

public class EncodeUtil {

    public static String convert(String content) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        String result = "";
        try {
            result = new String(content.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
