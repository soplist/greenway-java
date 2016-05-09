package com.greenway.pojo.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

import net.sf.json.JSONObject;

import com.greenway.pojo.impl.Message;
import com.greenway.pojo.impl.User;
import com.greenway.util.Calculate;
import com.greenway.util.Event;
import com.greenway.util.Point;
import com.greenway.util.TimePoint;

public class TestJava {
	
public static void main(String[] args) {
	TestJava test = new TestJava();
	//test.testShowDouble();
	//test.testCalculate();
	//test.split();
	//test.json();
	//System.out.println("string"+null);
	//test.getCurrentTime();
	//test.timeLine();
	//test.printTimestamp();
	//test.calculateSin();
	test.testTry();
}
public int testTry(){
	try{
		throw new Exception("exception msg");
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.print("1");
	return 1;
}
public void queue(){
	LinkedList list = new LinkedList();
	Vector v = new Vector();
	
}
public void testShowDouble(){
	try{
	double i,j;
	for(i=0,j=0;j<=2*Math.PI;i+=200/1000,j+=2*Math.PI/1000){
		System.out.println("i="+i+",j="+j);
	}
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
public void testCalculate(){
	Calculate c = new Calculate();
	c.setPoints(10);
	ArrayList<Point> a = c.getPoints();
	System.out.println("size:"+a.size());
	for(int i=0;i<a.size();i++){
		System.out.println("x="+a.get(i).getX()+",y="+a.get(i).getY());
	}
}
public void calculateSin(){
	java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
	double s =  (2*Math.sin(Math.PI));
	String str = df.format(s);
	System.out.println(str);
	double d = Double.valueOf(str);
	System.out.println(d);
}
public void printTimestamp(){
	System.out.println(java.sql.Timestamp.valueOf("2011-11-11 11:11:11"));
}
public void timeLine(){
	Message m = new Message();
	java.sql.Timestamp ts = java.sql.Timestamp.valueOf("2011-11-11 11:11:11");
	m.setDate(ts);
	m.setContent("hello world");
	
	Event event = new Event();
	event.setEventContent(m);
	
	TimePoint tp = new TimePoint();

	tp.setEvent(event);
	tp.setTimePoint();
	System.out.println(tp.getTimePoint());
	System.out.println(tp.getEvent().getEventContent().getContent());
}
public void getCurrentTime(){
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	String dateString = formatter.format(date);
	System.out.println(dateString);
}
public void json(){
	Message m = new Message();
	m.setId(1);
	m.setContent("com");
	m.setDate(java.sql.Timestamp.valueOf("2011-11-11 11:11:11"));
	User user = new User();
	user.setId(1);
	m.setUser(user);
	JSONObject json=JSONObject.fromObject(m);
    System.out.println(json);
    String result=json.toString();
    System.out.println(result);
	
}
public void split(){
	String str = "1 2 3  4 5";
	String[] ary = str.split(" ");
	System.out.println(ary.length);
	for(String item: ary){
		System.out.println(item);
	}
}
}
