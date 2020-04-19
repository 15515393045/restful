package com.car.admin.test71;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.apache.poi.ddf.EscherColorRef;

import javax.validation.constraints.Max;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-02-08 17:04
 **/
public class Test {

  /*  public static void main(String[] args) {
        int i1 = 21;
        //移动几位就是2的几次幂
        System.out.println(i1 << 2);//84
        System.out.println(i1 << 3);//168
        System.out.println(i1 << 4);//336
        System.out.println(i1 << 27);//-1476395008   符号位第一位变成了1为复数

        i1 = 2;
        System.out.println(i1 << 2);


        Map map = new HashMap();
        map.put("1", "张三");
        map.put("2", "里斯");
        map.put("3", "王五");

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getValue());
            System.out.println(next.getKey());
        }

        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String next = (String) iterator1.next();
            String o = (String) map.get(next);
            System.out.println(o);
            System.out.println(next);
        }

    }*/

  /*public static void main(String[] args){
      //&在二进制中表示全1则1,有0则0
      System.out.println(5&12);//4
      //|在二进制中表示全0则0,有1则1
      System.out.println(5|12);//13
      //^异或不一样为true，一样为false
      System.out.println(5^12);//9
      System.out.println(512);//9

      boolean a =false;
      System.out.println(!a);

      boolean b = true;
      //?("？号后面是对的"):("：号后面是错的")条件结果为boolean类型
      //根据表达式是真或是假来决定是表达式1还是表达式2
      //如果表达式为true则执行？号后面表达式，如果为false则执行false后面的表达式
      //类型根据表达式的结果而定
      //表达式1和表达式2的数据类型要求是一致的。
      //三元运算符是可以嵌套使用的
      System.out.println(b?("对"):("错"));

      int a1 = 50;
      int a2 = 200;
      int a3 = 300;

      int max = (a1>a2)?(a1<a3?a3:a1):(a1<a2?a2:a3);
      System.out.println(max);

      int max1 = (a1 > a2)?a1:a2;
      int max2 = (max1 > a3)?max1:a3;
      System.out.println(max2);

      int max3 = (((max1 > a3)?max1:a3) > a3)?((max1 > a3)?max1:a3):a3;
      System.out.println(max3);
  }*/

    public static void main(String[] args) {
        //DecimalFormat df2 = new DecimalFormat("###.00");
        int i = 29/3;
        //System.out.println(df2.format(i));
        i = 29%3;
        System.out.println(i);
    }
}
