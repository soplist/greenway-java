package com.greenway.exception;

public class UsernameException extends Exception {
    public UsernameException(){
    	super();
    }
    public UsernameException(String message){
    	super(message);
    }
    public UsernameException(String message,Throwable cause){
    	super(message,cause);
    }
    public UsernameException(Throwable cause){
    	super(cause);
    }
}
