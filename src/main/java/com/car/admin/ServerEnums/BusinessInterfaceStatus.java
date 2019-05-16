package com.car.admin.ServerEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program:
 * @description:
 * @author: Li_Heng
 * @create: 2019/3/25
 **/
@Getter
@AllArgsConstructor
public enum BusinessInterfaceStatus implements CodeEnum {

    /**
     * 操作成功
     */
    SUCCESS(0, "成功"),

    /**
     * 操作失败
     */
    FAIL(1, "fail");

    private final int code;
    private final String value;

}
