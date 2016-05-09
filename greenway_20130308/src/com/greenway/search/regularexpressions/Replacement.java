package com.greenway.search.regularexpressions;

import java.util.regex.Pattern;

public class Replacement {
    public static void main(String[] args)throws Exception{
	    Pattern p = Pattern.compile("[/]+"); 
	    System.out.println(p.flags()); 
	    //String[] result = p.split("aaa/bbbbb/c");
	    String[] result = p.split("aaa/bbbbb/c",2); 
	    for (int i=0; i<result.length; i++) 
		    System.out.println(result[i]); 
	}
}
