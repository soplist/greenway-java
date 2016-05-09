package com.greenway.springtest;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class AOPTest extends AbstractDependencyInjectionSpringContextTests{
   private AService aService;
   private BService bService;
   protected String[] getConfigLocations(){
	   String[] configs = new String[]{"applicationContext.xml"};
	   return configs;
   }
   /** 
    * test normal call 
    */  
   public void testCall()  
   {  
       System.out.println("SpringTest JUnit test");  
       aService.fooA("JUnit test fooA");  
       aService.barA();  
       bService.fooB();  
       bService.barB("JUnit test barB",0);  
   }  
     
   /** 
    * test After-Throwing 
    */  
   public void testThrow()  
   {  
       try {  
           bService.barB("JUnit call barB",1);  
       } catch (IllegalArgumentException e) {  
             
       }  
   }  
     
   public void setAService(AService service) {  
       aService = service;  
   }  
     
   public void setBService(BService service) {  
       bService = service;  
   }  
}  

