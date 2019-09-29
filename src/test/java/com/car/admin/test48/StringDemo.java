package com.car.admin.test48;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-24 21:20
 **/
public class StringDemo {
   
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            builder.append(s).append(",");
        }
        String substring = builder.substring(0, builder.length() - 1);
        //System.out.println(substring);

        int test = 0x80000001;
        int a = 0x80000000;
        int b = 0x7fffffff;
        int c = 0xFFFFFFFF;
        System.out.println(c);
        System.out.println(test);

        System.out.println(a);
        System.out.println(b);

        System.out.println(-2^31);
        System.out.println(2^31-1);

        Integer i = 100;
        Integer j = 100;
        System.out.print(i == j); //true
        Integer.valueOf(100);
        /**
         *java对于-128到127之间的数，会进行缓存，Integer i = 127时，
         * 会将127进行缓存，下次再写Integer j = 127时，就会直接从缓存中取，就不会new了。
         * Integer缓存了-128~127之间的数，这是在类加载期间就完成的。
         * 以后需要的时候直接指向它就可以了，省去了构造对象的开支，
         * 提高了效率。而大于127的数就需要重新指向了。
         *
         * 分析：
         * JVM会自动维护八种基本类型的常量池，
         * int常量池中初始化-128~127的范围，
         * 所以当为Integer i=127时，
         * 在自动装箱过程中是取自常量池中的数值，
         * 而当Integer i=128时，128不在常量池范围内，
         * 所以在自动装箱过程中需new 128，所以地址不一样。
         */

        int d = 100;
        //手动拆箱  i.intValue();  拆箱方法
        int i1 = i.intValue();

        System.out.println(Integer.toBinaryString(-100));//转换成二进制

    }

}
