package com.greenway.springtest.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Test {
public static void main(String[] args) {
	ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	Sleepable sleeper = (Sleepable)ctx.getBean("human");
	sleeper.sleep();
}
}
