package com.greenway.search;

import com.greenway.search.handle.inter.IHandleLink;
import com.greenway.util.SyncLinkedList;

public class DaoThread extends Thread{
	IHandleLink handleLink;
	DaoThread(){  
	}  
	    
	DaoThread(String szName,IHandleLink handleLink){  
	    super(szName);  
	    this.handleLink = handleLink;
	}  
	public void run(){  
		while(true){
		     if(handleLink.getSyncLinkedList().size()>100){
		    	 handleLink.storeLink();
		     }
		     else{
			     try {
				     this.sleep(5000);
			     } catch (InterruptedException e) {
				     // TODO Auto-generated catch block
				     e.printStackTrace();
			     }
		     }
		}
	}  
}
