package com.car.admin.test4;


import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDemo {


    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.setSex("男");

        //java对象转化为JSON字符串
        //JSON对象
        JSONObject fromObject = JSONObject.fromObject(student);
        //JSON数组
        JSONArray jsonArray = JSONArray.fromObject(student);

        //System.out.println("JSON对象："+fromObject);
        //System.out.println("JSON数组："+jsonArray);

        //JSON字符串转换JAVA对象
        Student bean = (Student) JSONObject.toBean(fromObject, Student.class);
        //System.out.println(bean);

        //JSON数组转换JAVA对象
        //获得jsonArray的第一个元素
        Object o = jsonArray.get(0);
        //将获取的第一个元素转换为JSON格式的字符串
        JSONObject jsonObject = JSONObject.fromObject(o);
        //通过toBean将JSON格式的字符串转换为JAVA对象
        Student stu = (Student) JSONObject.toBean(jsonObject, Student.class);
        //System.out.println(stu);

        //list和json字符串的互转
        List<Student> list = new ArrayList<>();
        list.add(student);

        //1.使用JSONObject将其转换为JSON格式的字符串
        //JSONObject listObject = JSONObject.fromObject(list);

        //2.使用JSONArray将其转换为JSON数组
        JSONArray array = JSONArray.fromObject(list);

        //这里会报'object' is an array. Use JSONArray instead的错
        //是因为在使用fromObject方法的时候会先进行参数类型的判断，
        //传入的参数是一个array类型，因为使用的ArrayList.
        //System.out.println(listObject.toString);

        //System.out.println(array.toString());

        //json字符串--》》list
        List list1 = JSONArray.toList(array, Student.class);
        for (Object o1 : list1) {
            //System.out.println(o1);
        }

        //将Json格式的字符串通过toArray方法转化为 数组arr
        Student[] o1 = (Student[]) JSONArray.toArray(array, Student.class);

        for (int i = 0; i < o1.length; i++) {
            Student student1 = o1[i];
            //System.out.println(student1);
        }

        //map和json字符串的互转
        Map<String, Student> map = new HashMap<>();
        map.put("stu",student);

        //1、JSONObject转换为对象
        JSONObject jsonObject1 = JSONObject.fromObject(map);
        //System.out.println(jsonObject1);

        //2、JSONArray转换为数组
        JSONArray jsonArray1 = JSONArray.fromObject(map);
        //System.out.println(jsonArray1);

        //json字符串--》》map
        Map map1 = new HashMap<>();
        //stu的值为JAVA对象
        map1.put("stu",Student.class);
        //第三个参数声明转换哪一个Map
        Map o2 = (Map) JSONObject.toBean(jsonObject1, Map.class, map1);
        System.out.println(o2);

    }

}
