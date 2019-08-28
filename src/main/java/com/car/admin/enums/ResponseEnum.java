/** 
 * <pre>项目名称:shop-admin-v1 
 * 文件名称:ResponseEnum.java 
 * 包名:com.fh.shop.backend.common 
 * 创建日期:2019年1月11日上午11:20:41 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.car.admin.enums;


public enum ResponseEnum implements IEnum{

	USERINFO_ERROR(300, "账号或密码为空!"),
	INTERFACE_ACCESSLIMIT(3004, "接口被限流了！"),
	INTERFACE_HEADERERROR(3005, "头部信息不完整！"),
	INTERFACE_OVERTIME(3006, "接口请求超时！"),
	INTERFACE_SIGNERROR(3007, "签名值错误！"),
	INTERFACE_INTERFACEATTACK(3006, "接口被攻击了！"),
	ERROR(-1, "ERROR"),
	SUCCESS(200, "OK");

	private int code;

	private String message;

	private ResponseEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}


	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
