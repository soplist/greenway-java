package com.greenway.springtest.aop2;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class BaseAfterThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Method arg0, Object[] arg1, Object arg2,Throwable throwable){
		System.out.println("delete error");
	}
}
