package com.car.admin.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author zhanyh
 * @description 金额计算工具类 PS:BigDecimal构造方法参数必须为String,否则某些特定的魔法数字会缺失精度
 * @date 2017年6月16日
 */
public class BigDecimalUtil {

    /**
     * 比较两个Double值的大小。 -1：值1小值2, 0:相等, 1：值1大于值2
     *
     * @param double1
     * @param double2
     * @return
     */
    public static int compareTo(Double double1, Double double2) {
        BigDecimal data1 = new BigDecimal(double1);
        BigDecimal data2 = new BigDecimal(double2);
        return data1.compareTo(data2);
    }

    /**
     * double转String
     *
     * @param value
     * @return
     */
    public static String DoubleToString(Double value) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = df.format(value);
        return str;
    }

    /**
     * 加法计算的add方法
     *
     * @param valueOne 被加数
     * @param valueTwo 加数
     * @return 两个参数的和
     */
    public static double add(String valueOne, String valueTwo) {
        BigDecimal bOne = new BigDecimal(valueOne);
        BigDecimal bTwo = new BigDecimal(valueTwo);
        return bOne.add(bTwo).doubleValue();
    }

    /**
     * 减法运算的sub方法
     *
     * @param valueOne 被减数
     * @param valueTwo 减数
     * @return 两个参数的差
     */
    public static double sub(String valueOne, String valueTwo) {
        BigDecimal bOne = new BigDecimal(valueOne);
        BigDecimal bTwo = new BigDecimal(valueTwo);
        return bOne.subtract(bTwo).doubleValue();
    }

    /**
     * 乘法运算
     *
     * @param valueOne 被乘数
     * @param valueTwo 乘数
     * @return 两个参数的积
     */
    public static double mul(String valueOne, String valueTwo) {
        BigDecimal bOne = new BigDecimal(valueOne);
        BigDecimal bTwo = new BigDecimal(valueTwo);
        return bOne.multiply(bTwo).doubleValue();
    }

    /**
     * 除法运算方法
     *
     * @param valueOne 被除数
     * @param valueTwo 除数
     * @param scale    精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double div(String valueOne, String valueTwo, int scale) {
        // 如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            scale = 0;
        }
        BigDecimal bOne = new BigDecimal(valueOne);
        BigDecimal bTwo = new BigDecimal(valueTwo);
        return bOne.divide(bTwo, scale, RoundingMode.HALF_UP).doubleValue();
    }
    
    /** 
    * @Description: 重新Bigdecimal求和
    * @Param: [in] 
    * @return: java.math.BigDecimal 
    * @Author: zhanyh
    * @Date: 2019/9/6 
    */ 
    public static BigDecimal ifNullSet0(BigDecimal in){
        if(in != null){
            return in;
        }
        return BigDecimal.ZERO;
    }

    /**
    * @Description:  重写Bigdecimal求和
    * @Param: [in]
    * @return: java.math.BigDecimal
    * @Author: zhanyh
    * @Date: 2019/9/6
    */
    public static BigDecimal sum(BigDecimal ...in){
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < in.length; i++) {
             result = result.add(ifNullSet0(in[i]));
        }
        return result;
    }
}
