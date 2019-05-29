package com.car.admin.test2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class GsonDemo {

    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","18");
        map.put("sex",null);

        /*用 Gson 的tojson方法会把 null 值忽略，从而序列化之后输出不包含这个属性值的 Json 串*/
/*        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        System.out.println(toJson);*/

            //展示null值
/*        GsonBuilder builder = new GsonBuilder();
        String json = builder.serializeNulls().create().toJson(map);
        System.out.println(json);*/

        UserBean bean = new UserBean();
        bean.setAge(18);
        bean.setName("张三");
        bean.setSex("男");

        //标有@Expose注解的字段才序列化   注意：在此加.create()方法,无法调用setVersion()方法！
        GsonBuilder gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
       /*标有@Since(3.2)注解的序列化；@Until(3.2)注解的
         在Version设置为3.2以前才会参与序列化。用于不同的版本。*/
        gson.setVersion(3.2);
        String json = gson.create().toJson(bean);
        System.out.println(json);

    }


}
