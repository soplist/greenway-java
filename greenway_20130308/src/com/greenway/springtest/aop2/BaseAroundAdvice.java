package com.greenway.springtest.aop2;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BaseAroundAdvice implements  MethodInterceptor{

	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}


}
