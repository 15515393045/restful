package com.car.admin;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

/*      Random random = new Random();
        String result = "N" + "";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }i

        System.out.println(result);
*/


        List list = new ArrayList();
        list.add(11);
        list.add("22");//编辑报错
        System.out.println(((Integer) list.get(1)) - 5);

        //java 之所以引入泛型是为了增强程序的安全性和正确性, 以便在编译期就能检查出类型相关的错误.
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(11);
        arr.add(22);
        System.out.println(((Integer) list.get(1)) - 5);

    }

}
