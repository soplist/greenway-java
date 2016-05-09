package com.greenway.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.greenway.pojo.inter.Person;

public class SpringAOPTest {
public static void main(String[] args) throws Exception{
	ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
    Person p = (Person)ctx.getBean("person");
    p.info();
    System.out.println("-------------------");
    p.run();
}
}
