package com.greenway.pojo.test;

public class DemoClass {
	public String pro1="123";
	public static String pro2="abc";
	public DemoClass(){
    }
    public DemoClass(Integer a,Integer b,String c){
    	System.out.println(a+b+c);
    }
	public String getPro1() {
		return pro1;
	}
    public String method1(Integer a,String b){
    	System.out.println(a+b);
    	return "123";
    }
    public static String method2(Integer a,Integer b,String c){
    	System.out.println(a+b+c);
    	return "456";
    }
	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}
}
