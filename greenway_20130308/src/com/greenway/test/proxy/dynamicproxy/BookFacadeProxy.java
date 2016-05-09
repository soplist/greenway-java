package com.greenway.test.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy  implements InvocationHandler{
    private Object target;
    
    public Object bind(Object target){
    	this.target = target;
    	return Proxy.newProxyInstance(target.getClass().getClassLoader(),
    			target.getClass().getInterfaces(), this);
    }

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		System.out.println("begin transaction");
		result = method.invoke(target, args);
		System.out.println("end transaction");
		return result;
	}
}
