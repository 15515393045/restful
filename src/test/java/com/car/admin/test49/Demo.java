package com.car.admin.test49;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-25 19:33
 **/
public class Demo {
    public static void main(String[] args) {


        JSONArray jsonArray = new JSONArray();
        jsonArray.add("1");
        jsonArray.add("2");
        if(jsonArray.size()>0){
            jsonArray.removeAll(jsonArray);
        }
     /*   jsonArray.add("1");
        jsonArray.add("2")*/;



        int size = jsonArray.size();
        System.out.println(size);


        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (int i = 0; i < list.size(); i++) {
            String o = (String) list.get(i);
            if(o.equals("c")){
                System.out.println(o);
                break;//终止循环
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String o = (String) list.get(i);
            if(o.equals("c")){
                continue;//结束当前循环进入下一次循环
            }
            System.out.println(o);
        }
    }


}
