package com.greenway.search.handle;

import java.util.ArrayList;

import com.greenway.pojo.impl.LinkStore;
import com.greenway.pojo.impl.LinkStoreDAO;
import com.greenway.pojo.inter.ILinkStoreDAO;
import com.greenway.search.QueueLinkedList;
import com.greenway.search.handle.inter.IHandleLink;
import com.greenway.util.SyncLinkedList;

public class HandleLink implements IHandleLink{
	private ILinkStoreDAO  linkDao = new LinkStoreDAO();
	private QueueLinkedList queueLinkList = new QueueLinkedList();
	private SyncLinkedList syncLinkedList = new SyncLinkedList();
	
	public SyncLinkedList getSyncLinkedList() {
		return syncLinkedList;
	}

	public void handle(){
		
	}
	
	public void pushLink(String strLink){
		LinkStore link = new LinkStore();
    	link.setLink(strLink);
    	link.setVisited(0);
    	queueLinkList.add(link);
		
	}
	public LinkStore getLink(){
		return queueLinkList.get();
	}
	public void addSyncLinkedList(LinkStore link){
		System.out.println("HandleLink:addSyncLinkedList");
		syncLinkedList.add(link);
	}
	public void storeLink(){
		System.out.println("HandleLink:store 100 link");
		ArrayList<LinkStore> list = syncLinkedList.getLinks(100);
		for(int i=0;i<list.size();i++){
		   linkDao.saveLink(list.get(i));
		   System.out.println("saved one link");
		}
	}
	
}
