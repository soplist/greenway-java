package com.greenway.search.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest {
   public static void main(String[] args) throws Exception{
	   Pattern p = Pattern.compile("(ca)(t)"); 
	   Matcher m = p.matcher("abcataaaacataabaacatab"); 
	   StringBuffer sb = new StringBuffer(); 
	   boolean result = m.find(); 
	   System.out.println("match group count£º"+m.groupCount());
	   
		   
   }
}
