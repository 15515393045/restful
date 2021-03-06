package com.car.admin.test68;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-09 10:37
 **/
public class CommonUtils {
    
    /** 
    * @Description: 分组依据接口，用于集合分组时，获取分组依据
    * @Author: zhanyh 
    * @Date: 2019/10/9 
    */
    public interface GroupBy<T> {
        T groupby(Object obj);
    }
    
    /** 
    * @Param: [colls, gb] 
    * @return: java.util.Map<T,java.util.List<D>> 
    * @Author: zhanyh 
    * @Date: 2019/10/9 
    */
    public static final <T extends Comparable<T>, D> Map<T, List<D>> group(Collection<D> colls, GroupBy<T> gb) {
        if(colls == null || colls.isEmpty()){
            System.out.println("分组集合不能为空！");
            return null;
        }
        if(gb == null){
            System.out.println("分组接口依据不能为空！");
            return null;
        }

        Iterator<D> iterator = colls.iterator();
        Map<T,List<D>>  map = new HashMap<>();
        while (iterator.hasNext()){
            D d = iterator.next();
            T t = gb.groupby(d);
            if(map.containsKey(t)){
                map.get(t).add(d);
            }else{
                List<D> list = new ArrayList<D>();
                list.add(d);
                map.put(t, list);
            }
        }

        return map;
    }

    /**
     * 将List<V>按照V的methodName方法返回值（返回值必须为K类型）分组，合入到Map<K, List<V>>中<br>
     * 要保证入参的method必须为V的某一个有返回值的方法，并且该返回值必须为K类型
     *
     * @param list
     *            待分组的列表
     * @param map
     *            存放分组后的map
     * @param clazz
     *            泛型V的类型
     * @param methodName
     *            方法名
     */
    public static <K, V> void listGroup2Map(List<V> list, Map<K, List<V>> map, Class<V> clazz, String methodName) {
        // 入参非法行校验
        if (null == list || null == map || null == clazz || StringUtils.isEmpty(methodName)) {
            System.out.print("CommonUtils.listGroup2Map 入参错误，list：" + list + " ；map：" + map + " ；clazz：" + clazz + " ；methodName：" + methodName);
            return;
        }

        // 获取方法
        Method method = getMethodByName(clazz, methodName);
        // 非空判断
        if(method == null){
            return;
        }
        // 正式分组
        listGroup2Map(list,map,method);

    }

    /**
     * 根据类和方法名，获取方法对象
     *
     * @param clazz
     * @param methodName
     * @return
     */
    public static Method getMethodByName(Class<?> clazz, String methodName) {
        Method method = null;
        // 入参不能为空
        if (null == clazz || StringUtils.isEmpty(methodName)) {
            System.out.print("CommonUtils.getMethodByName 入参错误，clazz：" + clazz + " ；methodName：" + methodName);
            return method;
        }

        try {
            method = clazz.getDeclaredMethod(methodName);
        } catch (Exception e) {
            System.out.print("类获取方法失败！");
        }

        return method;
    }

    /**
     * 将List<V>按照V的某个方法返回值（返回值必须为K类型）分组，合入到Map<K, List<V>>中<br>
     * 要保证入参的method必须为V的某一个有返回值的方法，并且该返回值必须为K类型
     *
     * @param list
     *            待分组的列表
     * @param map
     *            存放分组后的map
     * @param method
     *            方法
     */
    @SuppressWarnings("unchecked")
    public static <K, V> void listGroup2Map(List<V> list, Map<K, List<V>> map, Method method) {
        // 入参非法行校验
        if (null == list || null == map || null == method) {
            System.out.print("CommonUtils.listGroup2Map 入参错误，list：" + list + " ；map：" + map + " ；method：" + method);
            return;
        }

        try {
            // 开始分组
            Object key;
            List<V> listTmp;
            for (V val : list) {
                key = method.invoke(val);
                listTmp = map.get(key);
                if (null == listTmp) {
                    listTmp = new ArrayList<V>();
                    map.put((K) key, listTmp);
                }
                listTmp.add(val);
            }
        } catch (Exception e) {
            System.out.print("分组失败！");
        }
    }

    }
