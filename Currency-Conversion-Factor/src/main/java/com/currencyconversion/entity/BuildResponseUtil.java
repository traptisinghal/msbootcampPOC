package com.currencyconversion.entity;

public class BuildResponseUtil {

	String status;
	String msg;
	Object data;
	
	public BuildResponseUtil(String status, String msg,Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
