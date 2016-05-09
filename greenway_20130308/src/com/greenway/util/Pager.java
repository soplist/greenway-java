package com.greenway.util;

public class Pager {
     private long totalRows; 
     private int pageSize = 5;
     private int currentPage;
     private int totalPages;
     private int startRow;
     
     public Pager(){
    	 
     }
     public Pager(long totalRows){
    	 this.totalRows = totalRows;
    	 totalPages = (int) (totalRows/pageSize);
    	 int modRows = (int) (totalRows%pageSize);
    	 if(modRows>0){
    		 totalPages++;
    	 }
    	 currentPage = 1;
    	 startRow = 0;
     }
     public int getStartRow() {
    	 return startRow;
     }

     public int getTotalPages() {
    	 return totalPages;
     }

     public int getCurrentPage() {
    	 return currentPage;
     }

     public int getPageSize() {
    	 return pageSize;
     }

     public void setTotalRows(int totalRows) {
    	 this.totalRows = totalRows;
     }

     public void setStartRow(int startRow) {
    	 this.startRow = startRow;
     }

     public void setTotalPages(int totalPages) {
    	 this.totalPages = totalPages;
     }

     public void setCurrentPage(int currentPage) {
    	 this.currentPage = currentPage;
     }

     public void setPageSize(int pageSize) {
    	 this.pageSize = pageSize;
     }

     public long getTotalRows() {
    	 return totalRows;
     }

     public void first() {
    	 System.out.println("first");
    	 currentPage = 1;
    	 startRow = 0;
     }

     public void previous() {
    	 System.out.println("previous");
    	 if (currentPage == 1) {
    	     return;
    	 }
    	 currentPage--;
    	 startRow = (currentPage - 1) * pageSize;
     }

     public void next() {
    	 System.out.println("next");
    	 if (currentPage < totalPages) {
    	     currentPage++;
    	 }
    	 startRow = (currentPage - 1) * pageSize;
     }

     public void last() {
    	 System.out.println("last");
    	 currentPage = totalPages;
    	 startRow = (currentPage - 1) * pageSize;
     }

     public void refresh(int _currentPage) {
    	 currentPage = _currentPage;
    	 if (currentPage > totalPages) {
    	 last();
    	 }
     }

}
