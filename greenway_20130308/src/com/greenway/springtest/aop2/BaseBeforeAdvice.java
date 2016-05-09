package com.greenway.springtest.aop2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BaseBeforeAdvice implements MethodBeforeAdvice{

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("::in before advice");
		System.out.println("::object:"+arg2);
		System.out.println("::method:"+arg0);
		System.out.println("::delete:"+arg1[0]);
		
		System.out.println("::in point cut method");
		
	}

}
