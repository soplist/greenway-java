package com.greenway.search.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatch {
    public static void main(String[] args) {
    	String input_0 = "www,1:1";
    	String input = input_0;
    	Pattern p = Pattern.compile("^@|^\\."); 
    	Matcher m = p.matcher(input);  
    	if (m.find()){
    		System.out.println("can not begin with . or @");
    	}
    	p = Pattern.compile("^www."); 
    	m = p.matcher(input); 
    	if (m.find())
    		System.out.println("can not begin with www");
    	
    	
    	p = Pattern.compile("[^A-Za-z0-9.@_-~#]+"); 
    	m = p.matcher(input); 
    	StringBuffer sb = new StringBuffer(); 
    	boolean result = m.find(); 
    	boolean deletedIllegalChars = false; 
    	while(result) { 
    		deletedIllegalChars = true; 
    		m.appendReplacement(sb, ""); 
    		result = m.find(); 
    	} 
    	m.appendTail(sb); 
        input = sb.toString();
        
        if (deletedIllegalChars) { 
        	System.out.println("your input contain : ,... illegal char,please modify"); 
        	System.out.println("your input is:"+input_0); 
        	System.out.println("legal input is: "+input); 
        } 
    }
}
