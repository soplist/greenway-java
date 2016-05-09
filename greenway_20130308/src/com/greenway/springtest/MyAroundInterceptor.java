package com.greenway.springtest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundInterceptor implements MethodInterceptor{

	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before call method:invocation object:["+arg0+"]");
        Object rval = arg0.proceed();
        System.out.println("after call method...");
		return rval;
	}

}
