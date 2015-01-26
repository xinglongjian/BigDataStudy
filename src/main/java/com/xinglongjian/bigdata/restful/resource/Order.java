package com.xinglongjian.bigdata.restful.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement 
public class Order {
	private String orderNo;
	private String title;
	private int orderNum;
	private Date datetime;
	
	public Order()
	{
		
	}
	
	public Order(String orderNo, String title, int orderNum, Date datetime) {
		this.orderNo = orderNo;
		this.title = title;
		this.orderNum = orderNum;
		this.datetime = datetime;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
