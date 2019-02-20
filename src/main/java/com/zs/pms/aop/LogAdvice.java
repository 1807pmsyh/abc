package com.zs.pms.aop;

import static org.hamcrest.CoreMatchers.nullValue;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志通知
 * 声明式apo
 * @author Administrator
 *
 */
public class LogAdvice {
/*
 * 记录日志方法
 */
	public Object log(ProceedingJoinPoint method)throws Throwable{
		Object o=method.proceed(); //执行业务方法
		System.out.println("声明式apo记录日志"+method.getSignature().getName()+"------");
		return o;
	}
	
	
	
	
}
