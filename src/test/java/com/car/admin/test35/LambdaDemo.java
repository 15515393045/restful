package com.car.admin.test35;

import com.alibaba.fastjson.JSON;
import com.car.admin.bean.UserPlus;
import com.car.admin.mapper.UserMapper;
import com.car.admin.test30.XiaoMi;
import com.car.admin.util.BigDecimalUtil;
import com.google.gson.Gson;
import org.bouncycastle.crypto.generators.KDF1BytesGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-06 15:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaDemo {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Gson gson;


    @Test
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        List<UserPlus> userList = userMapper.selectList(null);

        /**
         * @Description: 分组
         * 根据性别进行分组
         * @return: void
         * @Author: zhanyh
         * @Date: 2019/9/6
         */
        Map<String, List<UserPlus>> collect = userList.stream().collect(Collectors.groupingBy(UserPlus::getSex));
        //key为女的所有数据
        List<UserPlus> womanList = collect.get("女");
        System.out.println("===================================================");
        System.out.println(JSON.toJSONString(womanList));

        System.out.println("===================================================");

        //key为男的所有数据
        List<UserPlus> manList = collect.get("男");
        System.out.println(JSON.toJSONString(manList));
        System.out.println("===================================================");


        /**
        * @Description: 过滤
        * 过滤掉家庭成员为4的数据
        * @return: void
        * @Author: zhanyh
        * @Date: 2019/9/6
        */
        List<UserPlus> collect1 = userList.stream().filter(a -> !a.getFamilyMemberQuantity().toString().equals("4")).collect(Collectors.toList());
        System.out.println(gson.toJson(collect1));

      /**
      * @Description: 求和
      * 分基本类型和大数类型求和，基本类型先mapToInt，
      * 然后调用sum方法，大数类型使用reduce调用BigDecimal::add方法
      * @return: void
      * @Author: zhanyh
      * @Date: 2019/9/6
      */
        //int sum = userList.stream().mapToInt(a -> a.getAge()).sum();
        //使用::
      int sum = userList.stream().mapToInt(UserPlus::getAge).sum();
        System.out.println("所有用户的年龄总和为："+sum);

        //大数据类型求和
        //BigDecimal求和
        //BigDecimal reduce = userList.stream().map(a -> a.getFamilyMemberQuantity()).reduce(BigDecimal.ZERO, BigDecimal::add);
        //注意：这种求和不能过滤bigDecimal对象为null的情况，否则会报空指针，这种情况，我们可以用filter方法过滤，或者重写求和方法
       BigDecimal reduce = userList.stream().map(UserPlus::getFamilyMemberQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("所有用户的家庭成员总和为："+reduce);
        //使用重写的方法
        BigDecimal reduce1 = userList.stream().map(UserPlus::getFamilyMemberQuantity).reduce(BigDecimal.ZERO, BigDecimalUtil::sum);
        System.out.println("所有用户的家庭成员总和为："+reduce1);

       /** 
       * @Description: 最值
       * 求最小与最大，使用min max方法
       * @return: void 
       * @Author: zhanyh
       * @Date: 2019/9/6 
       */
        //最小
        Date minDate = userList.stream().map(UserPlus::getEntryDate).min(Date::compareTo).get();
        System.out.println("最小时间："+sdf.format(minDate));
        //最大
        Date maxDate = userList.stream().map(UserPlus::getEntryDate).max(Date::compareTo).get();
        System.out.println("最大时间："+sdf.format(maxDate));

        /**
         * List 转map
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  user1,user2的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         *  根据Id查找数据
         */
        Map<Integer, UserPlus> collect2 = userList.stream().collect(Collectors.toMap(UserPlus::getId, a -> a, (k1, k2) -> k1));
        System.out.println(gson.toJson(collect2.get(1)));

        /**
        * @Description: 6.排序
         可通过Sort对单字段多字段排序
        * @Param: []
        * @return: void
        * @Author: zhanyh
        * @Date: 2019/9/6
        */
        //排序
        //单字段排序，根据id排序
        userList.sort(Comparator.comparing(UserPlus::getId));
        //多字段排序，根据id，年龄排序
        userList.sort(Comparator.comparing(UserPlus::getId).thenComparing(UserPlus::getEntryDate));

       /**
       * @Description: 去重
        可通过distinct方法进行去重
       * @Param: []
       * @return: void
       * @Author: zhanyh
       * @Date: 2019/9/6
       */
        //去重
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(1L);
        idList.add(2L);
        List<Long> list = idList.stream().distinct().collect(Collectors.toList());
        System.out.println(gson.toJson(list));

        /**
        * @Description: 获取list某个字段组装新list
        * @Param: []
        * @return: void
        * @Author: zhanyh
        * @Date: 2019/9/6
        */
        //获取list对象的某个字段组装成新list
        List<Date> collect3 = userList.stream().map(a -> a.getEntryDate()).collect(Collectors.toList());
        System.out.println(gson.toJson(collect3));

       /**
       * @Description:  批量设置list列表字段为同一个值
       * @Param: []
       * @return: void
       * @Author: zhanyh
       * @Date: 2019/9/6
       */
        userList.stream().forEach(a->a.setAge(20));
        
        /** 
        * @Description: 不同实体的list拷贝
        * @Param: [] 
        * @return: void 
        * @Author: zhanyh
        * @Date: 2019/9/6 
        */
        //List<TimePeriodDate> timePeriodDateList1 = calendarModelVoList.stream().map(p->{TimePeriodDate e = new TimePeriodDate(); e.setStartDate(p.getBegin());e.setEndDate(p.getEnd()); return e;}).collect(Collectors.toList());

    }


}
