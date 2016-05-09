package com.greenway.util;

import java.util.ArrayList;

public class Calculate {
private ArrayList<Point> points = new ArrayList<Point>();
private double r= 40;
private double steps = 200;
private double stepSizeRadius = r/steps;
public ArrayList<Point> getPoints() {
	coordinateTransformation();
	return points;
}

public void setPoints(int year) {
	java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
	double radius;
	double angle;
	for(radius=0,angle=0;angle<year*2*Math.PI;radius+=stepSizeRadius,angle+=Math.PI/100){
	      double x =  (radius*Math.cos(angle));
	      double y =  (radius*Math.sin(angle));
	      Point p = new Point(x,y);
	      //Point p = new Point(Double.valueOf(df.format(x)),Double.valueOf(df.format(y)));
	      points.add(p);
	      //System.out.println("x="+p.getX()+",y="+p.getY());
	}
}
public void coordinateTransformation(){
	for(int i=0;i<points.size();i++){
		points.set(i,new Point(points.get(i).getX()+600,points.get(i).getY()+400));
	}
}
}
