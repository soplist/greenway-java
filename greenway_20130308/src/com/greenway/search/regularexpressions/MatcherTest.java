package com.greenway.search.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
   public static void main(String[] args) throws Exception {
	   Pattern p = Pattern.compile("[b]"); 
	   Matcher m = p.matcher("babbabbbaabbbabbbabbbbbaaabbabbbbb");
	   StringBuffer sb = new StringBuffer();
	   int i=0;
	   boolean result = m.find(); 
	   
	   System.out.println("m.group(0)="+m.group(0));
	   
	   while(result) { 
		   //System.out.println("m.end(i)="+m.end(i));
		   Matcher title = Pattern.compile(">.*?</a>").matcher(m.group());
		   while (title.find()) {
		       System.out.println("±êÌâ:"+ title.group().replaceAll(">|</a>", ""));
		   }
		   /*
		   i++; 
		   System.out.println("m.groupCount()="+m.groupCount());
		   System.out.println("m.group()="+m.group());
		   System.out.println("m.group(0)="+m.group(0));
		   m.appendReplacement(sb, "i"); 
		   System.out.println("after "+i+" match,sb's content£º"+sb); 
		   System.out.println("m.end()="+m.end()); 
		   result = m.find(); */
	   } 
	   m.appendTail(sb); 
	   System.out.println("after call m.appendTail(sb) sb's final content:"+ sb.toString()); 
   }
}
