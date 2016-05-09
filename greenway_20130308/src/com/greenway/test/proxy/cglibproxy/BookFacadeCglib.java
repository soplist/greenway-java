package com.greenway.test.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookFacadeCglib implements MethodInterceptor{
    private Object target;
    public Object getInstance(Object target){
    	this.target = target;
    	Enhancer enhancer = new Enhancer();
    	enhancer.setSuperclass(this.target.getClass());
    	enhancer.setCallback(this);
    	return enhancer.create();
    }
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("begin transaction");
		proxy.invokeSuper(obj,args);
		System.out.println("end transaction");
		return null;
	}

}
