package com.car.admin.test70;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/*
    Java类初始化成员变量的时候不用赋值，
    而初始化局部变量就需要赋值，
    Java在初始化成员变量的时候会自动给成员变量赋值。

    3.总结 ：
        ①Java对成员变量的自动初始化并赋初始值，节省了开发的代码量；

        ②方法中的成员变量，则需要开发者在声明后，第一次使用该变量之前，显式的赋初始值，实例化该变量。
 */
public class ArrayTest {

    /**
     * 隐式初始化 初始值为0
     */
     private static int a;
     
     /**
      * 隐式初始化 初始值为null
      */
      private static String str;

    /**
     * 引用数据类型String,Interface... 默认为null
     * 注：引用型数据类型包括：类(class)、接口（interface）、数组（Array）、字符串（String），默认值都为null。
     */
      private static Integer[] integers;
    /**
     * 解释：
     * a，str，这二个变量是MyServlet类的成员变量，
     * 在类初始化的时候，会隐式的对成员变量赋初始值，
     * 初始值根据具体的变量类型而定,
     * str是String,属于引用型变量，所以会被初始化为null。
     * a是基本类型,所有会被初始化为0。
     */

    public static void main(String[] args) {

        int num = 8 << 1;//将数值8左移1位
        System.out.println(num);
        int num1 = 2 << 3;//8=2的3次方为8
        System.out.println(num1);
        System.out.println(8>>1);//8的二进制1000右移一位位0100;100的十进制是4

        char c = 'a';//97   b,c,d,,, 对应的ASCII码表中的 98,99,100,,, 依次向后推
        System.out.println(c+1);
        char c1 = 'A';//65   B,C,D,,, 对应的ASCII码表中的 66,67,68,,, 依次向后推
        System.out.println(c1+1);
        char c2 = '\u0000';
        System.out.println(c2);
        //Integer[] integers1 = null;//显示初始化
        System.out.println(integers);

        String str1 = null;//显式初始化
        //System.out.println(str1.length()+"哈哈哈");//编译通过运行报错
        //int a;
        //System.out.println(a);编辑不通。报错：The local variable a may not have been initialized。
        //局部变量在被使用之前，必须要进行显式的实例化（赋值），为变量分配内存空间后才能正常使用。
        int b = 10;//显式初始化  必须赋初始值
        System.out.println(b);//10
        System.out.println(str);//null
        System.out.println(a);//0
        /*
         同理，比如在if-else块，try-catch块中使用变量，
         变量必须在其外面经过初始化,及在其作用域范围内：{}
         */

        //定义并用运算符new为之分配空间后，才可以引用数组中的每个元素；
        int array[] = new int[3];
        //数组元素的引用方式：数组名[数组元素下标]
        array[0] = 23;
        array[1] = 11;
        array[2] = 8;
        Arrays.sort(array);
        System.out.println(JSON.toJSONString(array));

        String[] names;
        names = new String[3];
        names[0] = "张三";
        names[1] = "李四";
        names[2] = "王五";
        for(String name : names){
            System.out.println(name);
        }

        /*
            数组是引用类型，
            它的元素相当于类的成员变量，
            因此数组一经分配空间，
            其中的每个元素也被按照成员变量同样的方式被隐式初始化。
         */
        short[] shorts = new short[5];
        System.out.println(shorts[2]);
    }

}
