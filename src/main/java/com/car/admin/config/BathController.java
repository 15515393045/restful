/** 
 * <pre>项目名称:maven-shop 
 * 文件名称:BathController.java 
 * 包名:com.fh.shop.controller 
 * 创建日期:2019年1月25日下午6:03:21 
 * Copyright (c) 2019, 18500394470@163.com All Rights Reserved.</pre> 
 */  
package com.car.admin.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * <pre>项目名称：maven-shop    
 * 类名称：BathController    
 * 类描述：    
 * 创建人：ZhanYiHeng 1925815291@qq.com    
 * 创建时间：2019年1月25日 下午6:03:21    
 * 修改人：ZhanYiHeng 1925815291@qq.com    
 * 修改时间：2019年1月25日 下午6:03:21    
 * 修改备注：    
 * @version </pre>    
 */
public class BathController {

	protected static void rootPath(HttpServletRequest request){
		String rootPath = request.getServletContext().getRealPath("");
	}

	//将Json格式的字符串通过response响应给前台。
	public void outJson(String json,HttpServletResponse response){
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer.close();
				writer=null;
			}
		}
	}

}
