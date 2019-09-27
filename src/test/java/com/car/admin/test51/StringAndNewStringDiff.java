package com.car.admin.test51;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-27 17:38
 **/
public class StringAndNewStringDiff {
/*    public static void main(String[] args) {
        String a = "test";  //在常量池中创建test字符串对象，变量aa是对常量池中此对象的引用
        String aa = new String("test"); //由于前面语句已经在常量也中创建了test字符串对象，那么只会在堆中创建一个test对象，变量aa是对堆中此对象的引用
        String aaa = new String("test");//在堆中再创建一个test字符串对象，变量aaa是对堆中此对象的引用

        System.out.println("判断它们是否为同一对象（内存地址是否一致）：");
        System.out.println("a和aa：" + (a == aa));   //false
        System.out.println("a和aaa：" + (a == aaa));   //false
        System.out.println("aa和aaa：" + (aa == aaa));  //false

        System.out.println("判断它们常量池中的对象是否为同一对象（内存地址是否一致）：");
        System.out.println("a和aa：" + (a.intern() == aa.intern()));   //true
        System.out.println("a和aaa：" + (a.intern() == aaa.intern()));  //true
        System.out.println("aa和aaa：" + (aa.intern() == aaa.intern()));   //true

        System.out.println("判断它们引用的值字符串是否相等：");
        System.out.println("a和aa：" + a.equals(aa));   //true
        System.out.println("a和aaa：" + a.equals(aaa));  //true
        System.out.println("aa和aaa：" + aa.equals(aaa));   //true
    }*/

    public static void main(String[] args) {
        String a = "test";
        /**
         * 如果常量池中有test字符串对象（判断条件是equal方法返回true），
         * 就直接返回常量池中该对象引用给intern；如果没有，就会在常量池中创建test，
         * 再返回常量池中该对象的引用给intern。
         */
        String intern = a.intern();
        System.out.println(intern);
    }
}