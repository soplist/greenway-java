package com.greenway.springtest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAspect {
     @Pointcut("execution(* com.greenway.springtest..*.*(..))")
     public void inServiceLayer(){}
     public void doBeforeInServiceLayer(){
	      System.out.println("--------------");
	      System.out.println("Aop: do before in Service layer");
	      System.out.println("--------------");
	 }
}
