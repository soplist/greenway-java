package com.greenway.struts.action.impl;

import java.util.ArrayList;

import net.sf.json.JSONObject;

import com.greenway.util.Calculate;
import com.greenway.util.Point;
import com.opensymphony.xwork2.ActionSupport;

public class TimeLineAction  extends ActionSupport {
    private String result;
	private static final long serialVersionUID = 1L;
	public String drawTimeLine() throws Exception{
		Calculate c = new Calculate();
		c.setPoints(10);
		ArrayList<Point> list = c.getPoints();
		String jsonString="";
		for(int i=0;i<list.size();i++){
			if(i!=0)
		        jsonString += ","+JSONObject.fromObject(list.get(i)).toString();
			else
				jsonString += JSONObject.fromObject(list.get(i)).toString();
		}
		   
		this.result = "["+jsonString+"]";
		return "success";
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
