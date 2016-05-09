package com.greenway.springtest;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("after call method");
		System.out.println("target method return value"+arg0);
		System.out.println("target method:"+arg1);
		System.out.println("target method parameter:"+arg2);
		System.out.println("target object:"+arg3);
	}

}
