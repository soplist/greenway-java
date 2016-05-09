package com.greenway.springtest.aop2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class BaseAfterReturnAdvice implements AfterReturningAdvice{

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("in after returning advice");
		
		System.out.println("object:"+arg3);
		System.out.println("method:"+arg1);
		//System.out.println("delete:"+arg2[0]);
		System.out.println("return value:"+arg0);
	}

}
