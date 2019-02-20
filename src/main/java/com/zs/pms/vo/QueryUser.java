package com.zs.pms.vo;

import java.io.Serializable;

public class QueryUser implements Serializable{

	/**
	 * 查询用表
	 */
	private static final long serialVersionUID = -710552882056463335L;

	

	
	//用户名
	private String loginname;
	//密码
	private String password;
	//性别
	private String sex;
	//是否可用
	private int isenabled;
	
	private int start;  //起始数
	private int end;    //截止数
	
	
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
