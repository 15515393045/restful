/** 
 * <pre>项目名称:shop-admin-v1 
 * 文件名称:ServerResponse.java 
 * 包名:com.fh.shop.backend.common 
 * 创建日期:2019年1月9日下午12:03:36 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.car.admin.enums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ResponseServer<T> implements Serializable{
	
	private static final long serialVersionUID = 1830682094599780635L;

	private int code;
	
	private String message;
	
	private T data;
	
	
	private ResponseServer() {
		
	}
	
	
	private ResponseServer(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static ResponseServer error(int code, String message) {
		return new ResponseServer(code, message, null);
	}
	
	public static ResponseServer error(IEnum responseEnum) {
		return new ResponseServer(responseEnum.getCode(), responseEnum.getMessage(), null);
	}
	
	public static ResponseServer error() {
		return new ResponseServer(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMessage(), null);
	}
	
	
	public static ResponseServer success() {
		return new ResponseServer(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), null);
	}
	
	public static <T> ResponseServer<T> success(T data) {
		return new ResponseServer(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), data);
	}
	
	
	

	public int getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public T getData() {
		return data;
	}



	
}
