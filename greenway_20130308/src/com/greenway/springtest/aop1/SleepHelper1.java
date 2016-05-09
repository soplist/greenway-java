package com.greenway.springtest.aop1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class SleepHelper1 {
public SleepHelper1(){
	
}
@Pointcut("execution(* *.sleep())")
public void sleeppoint(){}

@Before("sleeppoint()")
public void beforeSleep(){
	System.out.println("before sleep");
}

@AfterReturning("sleeppoint()")
public void afterSleep(){
	System.out.println("after sleep");
}
}
