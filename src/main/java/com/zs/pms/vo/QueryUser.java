package com.zs.pms.vo;

import java.io.Serializable;

public class QueryUser implements Serializable{

	/**
	 * ��ѯ�ñ�
	 */
	private static final long serialVersionUID = -710552882056463335L;

	

	
	//�û���
	private String loginname;
	//����
	private String password;
	//�Ա�
	private String sex;
	//�Ƿ����
	private int isenabled;
	
	private int start;  //��ʼ��
	private int end;    //��ֹ��
	
	
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