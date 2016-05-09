package com.greenway.springtest.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {
public static void main(String[] args) {
	ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	Order order = (Order)ctx.getBean("order_3");
	System.out.println("order num:"+order.getOrderNum());
	System.out.println("order item dec:"+order.getOrderItem().getOrderdec());
}
}
