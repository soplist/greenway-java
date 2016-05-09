package com.greenway.search.handle.inter;

import com.greenway.pojo.impl.LinkStore;
import com.greenway.util.SyncLinkedList;

public interface IHandleLink {
	
	public void handle();
	
	public void pushLink(String strLink);
	
	public void storeLink();
	
	public LinkStore getLink();
	
	public void addSyncLinkedList(LinkStore link);
	
	public SyncLinkedList getSyncLinkedList();
}
