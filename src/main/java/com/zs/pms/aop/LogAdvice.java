package com.zs.pms.aop;

import static org.hamcrest.CoreMatchers.nullValue;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ��־֪ͨ
 * ����ʽapo
 * @author Administrator
 *
 */
public class LogAdvice {
/*
 * ��¼��־����
 */
	public Object log(ProceedingJoinPoint method)throws Throwable{
		Object o=method.proceed(); //ִ��ҵ�񷽷�
		System.out.println("����ʽapo��¼��־"+method.getSignature().getName()+"------");
		return o;
	}
	
	
	
	
}
