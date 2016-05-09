package com.greenway.util;

import javax.servlet.http.HttpServletRequest;

public class PagerHelper {
	public static Pager getPager(HttpServletRequest httpServletRequest,long totalRows){
		Pager pager;
		if(null==httpServletRequest.getSession().getAttribute("PAGER")){
		    System.out.println("PAGER=null");
			pager = new Pager(totalRows);
			
		}else{
			System.out.println("PAGER!=null");
			pager = (Pager) httpServletRequest.getSession().getAttribute("PAGER");
		}
		String currentPage = httpServletRequest.getParameter("currentPage");
		if (currentPage != null) {
			pager.refresh(Integer.parseInt(currentPage));
		}
		
		String pagerMethod = httpServletRequest.getParameter("pagerMethod");
        System.out.println("pagerMethod="+pagerMethod);
		if (pagerMethod != null) {
		if (pagerMethod.equals("first")) {
		     pager.first();
		} else if (pagerMethod.equals("previous")) {
		     pager.previous();
		} else if (pagerMethod.equals("next")) {
		     pager.next();
		} else if (pagerMethod.equals("last")) {
		     pager.last();
		}
		}
		return pager;
	}

}
