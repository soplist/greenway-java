package com.greenway.springtest;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before call method");
		System.out.println("call method message");
		System.out.println("execute method:"+arg0);
		System.out.println("call method parameter:"+arg1);
		System.out.println("target object:"+arg2);
	}

}
