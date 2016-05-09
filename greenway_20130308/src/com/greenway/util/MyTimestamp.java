package com.greenway.util;

import java.sql.Timestamp;

public class MyTimestamp extends Timestamp{
	private static final long serialVersionUID = 1L;

	public MyTimestamp(int year, int month, int date, int hour, int minute,
			int second, int nano) {
		super(year, month, date, hour, minute, second, nano);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	
	public String toString(){
		return "";
	}

}
