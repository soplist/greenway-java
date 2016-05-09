package com.greenway.springtest.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Debug {
public static void main(String[] args) {
	ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	IBaseBusiness business = (IBaseBusiness )ctx.getBean("businessProxy");
	business.delete("001");
}
}
