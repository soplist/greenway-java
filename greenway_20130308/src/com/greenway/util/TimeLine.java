package com.greenway.util;

import java.util.ArrayList;

public class TimeLine {
   private int uid;
   private ArrayList<TimePoint> timeLine;

   public int getUid() {
	   return uid;
   }

   public void setUid(int uid) {
	   this.uid = uid;
   }

   public ArrayList<TimePoint> getTimeLine() {
	   return timeLine;
   }

   public void setTimeLine(ArrayList<TimePoint> timeLine) {
	   this.timeLine = timeLine;
   }
   public void addTimePoint(TimePoint tp){
	   timeLine.add(tp);
	   
   }
   public void removeTimePoint(int index){
	   timeLine.remove(index);
   }
}
