package com.greenway.springtest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAdvice {
@Before("com.greenway.springtest.SampleAspect.inServiceLayer()")
public void logInfo(){
	System.out.println("--------------");
    System.out.println("Aop: do before in Service layer");
    System.out.println("--------------");
}
}
