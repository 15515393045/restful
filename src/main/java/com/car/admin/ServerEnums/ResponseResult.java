package com.car.admin.ServerEnums;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @program:
 * @description: 通用返回值处理类
 * @author: Li_Heng
 * @create: 2019/3/25
 **/
@Data
@Accessors(chain = true)
public class ResponseResult<T> implements Serializable {

    private int resultCode;
    private String message;
    private T data;

    /**
     * 返回成功数据（status：200）
     *
     * @param data 数据内容
     * @param <T>  数据类型
     * @return ResponseResult实例
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult().setResultCode(BusinessInterfaceStatus.SUCCESS.getCode()).setMessage(BusinessInterfaceStatus.SUCCESS.getValue()).setData(data);
    }

    /**
     * 返回成功数据（status：200）
     *
     * @return ResponseResult实例
     */
    public static ResponseResult success() {
        return success(null);
    }


    /**
     * 返回错误数据（status：500）
     *
     * @param data 错误内容
     * @param <T>  数据类型
     * @return ResponseResult实例
     */
    public static <T> ResponseResult fail(T data) {
        return new ResponseResult().setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setMessage(HttpStatus.INTERNAL_SERVER_ERROR.name()).setData(data);
    }

    /**
     * 自定义返回错误数据
     *
     * @param resultCode    错误代码
     * @param message 错误消息
     * @return ResponseResult实例
     */
    public static ResponseResult fail(int resultCode, String message) {
        return new ResponseResult().setResultCode(resultCode).setMessage(message);
    }

    /**
     * @param resultCode    错误代码
     * @param message 错误消息
     * @param data    错误内容
     * @return ResponseResult实例
     */
    public static ResponseResult fail(int resultCode, String message, String data) {
        return new ResponseResult().setResultCode(resultCode).setMessage(message).setData(data);
    }
}
