package com.greenway.springtest.injection;

public class Order {
   private String orderNum;
   
   private OrderItem orderItem;
   
   public Order(){
   }
   public Order(OrderItem orderItem){
	  this.orderItem = orderItem;
   }
   
   public String getOrderNum() {
	  return orderNum;
   }

   public void setOrderNum(String orderNum) {
	  this.orderNum = orderNum;
   }

   public OrderItem getOrderItem() {
	  return orderItem;
   }

   public void setOrderItem(OrderItem orderItem) {
	  this.orderItem = orderItem;
   }
}
