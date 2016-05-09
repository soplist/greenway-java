package com.greenway.util;

import java.util.ArrayList;
import java.util.LinkedList;

import com.greenway.pojo.impl.LinkStore;

public class SyncLinkedList {
   private LinkedList<LinkStore> linkedList = new LinkedList<LinkStore>();

   public LinkedList<LinkStore> getLinkedList() {
	   return linkedList;
   }

   public void setLinkedList(LinkedList<LinkStore> linkedList) {
	   this.linkedList = linkedList;
   }

   public void add(LinkStore link){
	   linkedList.addFirst(link);
   }
   
   public LinkStore get(){
	   if(linkedList.size() != 0)
	       return linkedList.getLast();
	   return null;
   }
   
   public int size(){
	   return linkedList.size();
   }
   
   public ArrayList<LinkStore> getLinks(int size){
	   synchronized(linkedList){
		   ArrayList<LinkStore> lists = new ArrayList<LinkStore>();
		   int n = linkedList.size();
		   if(size<n){
		       for(int i = n-1;i>n-size-1;i--){
				   lists.add(linkedList.get(i));
				   linkedList.remove(i);
		       }
		   }
		   return lists;
	   }
	   
   }
   
}
