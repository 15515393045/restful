package com.car.admin.test45;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-20 16:08
 **/
public class ArrayListOrLinkedListDemo {

    public static void main(String[] args) {
        List arrayList = new ArrayList();

        List linkedList = new LinkedList();

        long arrayListExcuteTime = insertExcuteTime(arrayList);
        long linkedListExcuteTime = insertExcuteTime(linkedList);

        System.out.println("arrayList执行十万次插入大概需要："+arrayListExcuteTime+"ms");
        System.out.println("linkedListExcuteTime执行十万次插入大概需要："+linkedListExcuteTime+"ms");

        dataPrpare(arrayList);
        dataPrpare(linkedList);

        long arrayListFindExcuteTime = findExcuteTime(arrayList,"张三99999");
        long linkedLisFindtExcuteTime = findExcuteTime(linkedList,"张三99999");

        System.out.println("arrayListFindExcuteTime执行十万次查询大概需要："+arrayListFindExcuteTime+"ms");
        System.out.println("linkedLisFindtExcuteTime执行十万次查询大概需要："+linkedLisFindtExcuteTime+"ms");
    }

    /** 
    * @Description: 插入集合的执行时间 
    * @Param: [list] 
    * @return: long 
    * @Author: zhanyh 
    * @Date: 2019/9/20 
    */
    public static long insertExcuteTime(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
             list.add("张三");
        }
        long endTime = System.currentTimeMillis();

        return endTime-startTime;
    }
    
    /** 
    * @Description: 查询的执行时间 
    * @Param: [list, findString] 
    * @return: long 
    * @Author: zhanyh 
    * @Date: 2019/9/20 
    */
    public static long findExcuteTime(List list,String findString){
        
        long startTime = System.currentTimeMillis();
        
            list.contains(findString);
            
        long endTime = System.currentTimeMillis();
        
        return endTime-startTime;
    }

    /** 
    * @Description: 数据准备 
    * @Param: [list] 
    * @return: void 
    * @Author: zhanyh 
    * @Date: 2019/9/20 
    */
    public static void dataPrpare(List list){
        for (int i = 0; i <1000000; i++) {
            list.add("张三"+i);
        }
    }
}
