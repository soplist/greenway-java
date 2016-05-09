package com.greenway.util;

import com.greenway.pojo.inter.IContent;

public class Event {
   private int eventType;
   private IContent eventContent;

   public IContent getEventContent() {
	   return eventContent;
   }

   public void setEventContent(IContent eventContent) {
	   this.eventContent = eventContent;
   }

   public int getEventType() {
	   return eventType;
   }

   public void setEventType(int eventType) {
	   this.eventType = eventType;
   }
   
}
