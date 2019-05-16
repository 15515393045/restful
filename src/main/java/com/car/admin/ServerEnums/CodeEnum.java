package com.car.admin.ServerEnums;

/**
 * @program:
 * @description:通用枚举接口
 * @author: Li_Heng
 * @create: 2019/3/25
 **/
public interface CodeEnum {

    /**
     * 返回枚举体的code值
     *
     * @return code值
     */
    int getCode();

    /**
     * 返回枚举体的code值
     *
     * @return 字符串格式的code值
     */
    default String getCodeAsString() {
        return "" + getCode();
    }

}
