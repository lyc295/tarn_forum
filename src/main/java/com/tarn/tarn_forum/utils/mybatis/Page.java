package com.tarn.tarn_forum.utils.mybatis;

import java.io.Serializable;


public class Page implements Serializable {

	private Integer size; // 每页大小
	private Integer number; // 当前页码
	private String orderByClause; //排序

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public Page(Integer size, Integer number) {
		this.size = size;
		this.number = number;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	// 获取开始 页数 因为mysql默认是0开始的
	public Integer getBegin() {
		return size * (number - 1);
	}

	//获取 最后 页数
	public Integer getEnd() {
		return size * number;
	}
}