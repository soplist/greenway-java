package com.greenway.test.proxy.staticproxy;

public class CountProxy implements Count {
    private CountImpl countImpl;
    
    public CountProxy(CountImpl countImpl){
    	this.countImpl = countImpl;
    }
    
	public void queryCount() {
		// TODO Auto-generated method stub
		System.out.println("before transaction processing");
		countImpl.queryCount();
		System.out.println("after transaction processing");
	}

	public void updateCount() {
		// TODO Auto-generated method stub
		System.out.println("before transaction processing");
		countImpl.updateCount();
		System.out.println("after transaction processing");
	}

}
