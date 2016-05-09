package com.greenway.search.sync;

public class FineGrainLock {
	MyMemberClass x, y;
	Object xlock = new Object(), ylock = new Object();
	public void foo() {
	   synchronized(xlock) {
	       //access x here
	   }
	   //do something here - but don¡®t use shared resources
	   synchronized(ylock) {
	       //access y here
	   }
	}
	public void bar() {
	   synchronized(this) {
	       //access both x and y here
	   }
	   //do something here - but don¡®t use shared resources
	}
}
