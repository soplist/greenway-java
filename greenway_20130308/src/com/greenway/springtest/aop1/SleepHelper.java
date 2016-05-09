package com.greenway.springtest.aop1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before sleep");
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("after sleep");
	}

}
