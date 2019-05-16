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


public class ServerResponse<T> implements Serializable{
	
	private static final long serialVersionUID = 1830682094599780635L;

	private int code;
	
	private String message;
	
	private T data;
	
	
	private ServerResponse() {
		
	}
	
	
	private ServerResponse(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static ServerResponse error(int code, String message) {
		return new ServerResponse(code, message, null);
	}
	
	public static ServerResponse error(IEnum responseEnum) {
		return new ServerResponse(responseEnum.getCode(), responseEnum.getMessage(), null);
	}
	
	public static ServerResponse error() {
		return new ServerResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMessage(), null);
	}
	
	
	public static ServerResponse success() {
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), null);
	}
	
	public static <T> ServerResponse<T> success(T data) {
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), data);
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
