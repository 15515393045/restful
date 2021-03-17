package com.car.admin.test86;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.jmx.export.metadata.ManagedOperation;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-20 17:23
 **/
public class JsonDemo {

    public static void main(String[] args) {
        String arr = "[{'name':'张三'},{'name':'赵六'},{'name':'王五'},{'name':'李四'}]";

      /*  List<Object> arr1 = JSON.parseArray(arr, Object.class);
        for (Object o : arr1) {
            JSONObject parse = (JSONObject) o;
            System.out.println(parse.toString());
            String name = parse.getString("name");
            System.out.println(name);
        }*/

       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map map = new HashMap();
        map.put("name","张三");
        map.put("age",15);
        map.put("sex","男");
        map.put("生日",dateFormat.format(new Date()));
        //System.out.println(map.get("生日"));
        JSONObject jsonObject = (JSONObject) JSON.toJSON(map);

        System.out.println(jsonObject);*/

       /*JSONObject obj = new JSONObject();
        boolean empty = obj.isEmpty();
        System.out.println(empty);//true
        obj.put("name","张三");
        System.out.println(obj.isEmpty());//false  */

       String str = "[{'name1':{'name2':{'name3':'value1','name4':'value2'}}},{}]";

        /*JSONArray parameter = JSON.parseArray(str);
        for (Object o : parameter) {
        JSONObject object = (JSONObject) o;
            JSONObject name1 = (JSONObject) object.get("name1");
               JSONObject name2 = (JSONObject) name1.get("name2");
                Map<String,String> map = (Map) name2;
                String name4 = map.get("name4");
                System.out.println(name4);
        }
*/

    }




}
