package com.greenway.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Hibernate;

import com.greenway.pojo.impl.LinkStore;
import com.greenway.pojo.impl.LinkStoreDAO;
import com.greenway.pojo.impl.Page;
import com.greenway.pojo.impl.PageDAO;
import com.greenway.pojo.inter.ILinkStoreDAO;
import com.greenway.pojo.inter.IPageDAO;
import com.greenway.search.handle.HandleLink;
import com.greenway.search.handle.inter.IHandleLink;

public class TestSearch {
	
	private IPageDAO  pageDao = new PageDAO();
	
	IHandleLink handleLink = new HandleLink();
	
	public IHandleLink getHandleLink() {
		return handleLink;
	}


	public static void main(String[] args) {
		TestSearch ts = new TestSearch();
		ts.readURL("http://www.yahoo.com");
		DaoThread daoThread = new DaoThread("DaoThread",ts.getHandleLink());
		daoThread.start();
	}
	

    public void readURL(String link){
	    try { 
            URL url = new URL(link); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); 
            String line; 

            try {
            	   File file = new File("F:\\a.txt");
            	   if(file.exists()){
            	    System.out.print("file exist");
            	   }else{
            	    System.out.print("file not exist");
            	    file.createNewFile();
            	   }
            	   StringBuffer sb = new StringBuffer("");  
            	   BufferedWriter output = new BufferedWriter(new FileWriter(file));
            	   while ((line = reader.readLine()) != null) { 
            		   //getAllURL(line);
            		   getAllURL(line);
            		   sb.append(line + "/r/n");  
                   	   output.write(line);
                       //System.out.println(line);
                   } 
            	   String s = sb.toString();
            	   Page page = new Page();
            	   byte[] b = s.getBytes();
            	   page.setWebPage(Hibernate.createBlob(b));
            	   //page.setWebPage("¹þ¹þ");
            	   System.out.println(sb.toString());
            	   
            	   pageDao.savePage(page);
            	   output.close();
            } catch (Exception e) {
            	   e.printStackTrace();
            }
            reader.close(); 
            

        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
    	    e.printStackTrace(); 
        }
	    LinkStore l = handleLink.getLink();
	    handleLink.addSyncLinkedList(l);
	    readURL(l.getLink());
    }

    public void getAllURL(String doc)
    {
        int i = 0;
        String regex = "<a.*?/a>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(doc);
        while (m.find()) {
            //System.out.println(m.group());
            i++;
            // get title
            final Matcher title = Pattern.compile(">.*?</a>").matcher(m.group());
            while (title.find()) {
                //System.out.println("title:"+ title.group().replaceAll(">|</a>", ""));
            }
            // get address
            //final Matcher myurl = Pattern.compile("href=.*?>").matcher(m.group());
            final Matcher myurl = Pattern.compile("href=(\"|\').*?(\"|\')").matcher(m.group());
            while (myurl.find()) {
            	//System.out.println(myurl.group());
            	//String strLink = myurl.group().replaceAll("href=(\"|\')|(\"|\')>", "");
            	String strLink = myurl.group().replaceAll("href=(\"|\')|(\"|\')", "");
            	
            	handleLink.pushLink(strLink);
                //System.out.println("address:" +strLink );
            }
            System.out.println();
        }
        System.out.println("total have " + i + " result");
    }
    
   
}
