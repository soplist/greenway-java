package com.greenway.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class TimePoint {
    private Date timePoint;
    private Event event;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Date getTimePoint() {
		return timePoint;
	}

	public void setTimePoint() {
		try {
		    Class eventClass = event.getEventContent().getClass();
		    Class[] argsClass = {};
		    Object[] args = {};
		    Method method = eventClass.getMethod("getDate", argsClass);
		    this.timePoint =  (Date) method.invoke(event.getEventContent(), args);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
