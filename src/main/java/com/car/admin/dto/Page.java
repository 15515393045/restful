package com.car.admin.dto;

import lombok.Data;

@Data
public class Page {
	
	//总条数
	private long  totalCount;
	//总页数
	private long pageCount;
	//每页的条数
	private long pageSize = 3;
	//当前页
	private long pageIndex = 1;
	//起始位置的下标
	private long startPos;
	//终止位置
	private long endPos;

	//计算分页信息
	public void calculatePage(){
		//获取总页数
		if(totalCount % pageSize ==0){
			pageCount = totalCount / pageSize;
		}else{
			pageCount = totalCount / pageSize + 1;
		}
		// 1 0 5 >0 <=5
		// 2 5 10 >5 <=10
		// 3 10 15 >10 <=15
		//当前页减一乘以每页条数等于开始位置的下标
		startPos = ( pageIndex - 1 ) * pageSize;
		//当前页乘以每页条数=结束位置
		endPos = pageIndex * pageSize;
	}

}
