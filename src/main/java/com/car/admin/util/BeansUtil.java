package com.car.admin.util;

import com.car.admin.ServerEnums.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * @program:
 * @description:
 * @author: Li_Heng
 * @create: 2019/3/25
 **/
@Slf4j
public class BeansUtil {

    public BeansUtil() {
    }

    public static <T> T copyProperties(Object source, T target) {
        try {
            BeanUtils.copyProperties(source, target);
        } catch (BeansException var3) {
            log.error("copy properties error ", var3);
            handleReflectionException(var3);
        }

        return target;
    }

    /**
     * 复制属性忽略空值
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T copyPropertiesIgnoreNull(Object source, T target) {
        try {
            BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        } catch (BeansException var3) {
            log.error("copy properties error ", var3);
            handleReflectionException(var3);
        }
        return target;
    }

    public static <T> T convert(Object source, Class<T> tClass) {
        Object t = null;

        try {
            t = tClass.newInstance();
            if(source == null) {
                return null;
            }
            BeanUtils.copyProperties(source, t);
        } catch (Exception var4) {
            log.error("tClass convert error ", var4);
            handleReflectionException(var4);
        }
        return (T) t;
    }

    public static <T> List<T> convert(List<?> source, Class<T> tClass) {
        ArrayList result = new ArrayList();
        try {
            Iterator var3 = source.iterator();

            while(var3.hasNext()) {
                Object o = var3.next();
                if(o != null) {
                    T t = tClass.newInstance();
                    BeanUtils.copyProperties(o, t);
                    result.add(t);
                }
            }
        } catch (Exception var6) {
            log.error("List convert error ", var6);
            handleReflectionException(var6);
        }
        return result;
    }

    /**
     * 将ResponseResult解析为指定的类
     *
     * @param result    ResponseResult
     * @param clazz     指定的类
     * @param <T>指定的类类型
     * @return 指定的类的实例
     * @throws Exception 异常
     */
    public static <T> T parse(@Nullable ResponseResult result, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mapper.writeValueAsString(result != null ? result.getData() : null), clazz);
    }

    private static String[] getNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet();
        PropertyDescriptor[] var4 = pds;
        int var5 = pds.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            PropertyDescriptor pd = var4[var6];
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return (String[])emptyNames.toArray(result);
    }

    private static void handleReflectionException(Exception e) {
        ReflectionUtils.handleReflectionException(e);
    }
}
