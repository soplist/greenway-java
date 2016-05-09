package com.greenway.springtest.aop2;

import java.lang.reflect.Method;

import org.springframework.aop.support.NameMatchMethodPointcut;

public class Pointcut extends NameMatchMethodPointcut {
	private static final long serialVersionUID = 3990456017285944475L;

    @SuppressWarnings("rawtypes")
    @Override
    public boolean matches(Method method, Class targetClass) {
        this.setMappedName("delete");
        String[] methods = { "delete", "modify" };
        this.setMappedNames(methods);
        return super.matches(method, targetClass);
    }
}
