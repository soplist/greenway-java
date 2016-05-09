package com.greenway.pojo.test;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Hibernate;



import com.greenway.pojo.inter.IArticleDAO;
import com.greenway.pojo.inter.IGroDAO;
import com.greenway.pojo.inter.IMessageDAO;
import com.greenway.pojo.inter.IPageDAO;
import com.greenway.pojo.inter.IUserGroupStructureDAO;
import com.greenway.pojo.inter.IUserDAO;
import com.greenway.pojo.impl.ArticleDAO;
import com.greenway.pojo.impl.GroDAO;
import com.greenway.pojo.impl.LinkStore;
import com.greenway.pojo.impl.LinkStoreDAO;
import com.greenway.pojo.impl.Message;
import com.greenway.pojo.impl.MessageDAO;
import com.greenway.pojo.impl.Page;
import com.greenway.pojo.impl.PageDAO;
import com.greenway.pojo.impl.UserGroupStructureDAO;
import com.greenway.pojo.impl.UserDAO;
import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gro;
import com.greenway.pojo.impl.UserGroupStructure;
import com.greenway.pojo.impl.User;


public class DaoTest {
  private IUserDAO userDAO = new UserDAO();
  private IUserGroupStructureDAO ugStructureDao = new UserGroupStructureDAO();
  private IGroDAO groDAO = new GroDAO();
  private IArticleDAO articleDAO = new ArticleDAO();
  private IMessageDAO messageDAO = new MessageDAO();
  private IPageDAO pageDAO = new PageDAO();
  private LinkStoreDAO linkDAO = new LinkStoreDAO();
  public static void main(String[] args) {
	  DaoTest test = new DaoTest();
	  //test.testSaveRegisterUser();
	  //test.testListUsers();
	  //test.testAddUserToGroup();
	  //test.testAddMiddleUserGroupRelation();
	  //test.testListGroupsByUserId();
	  //test.testqueryArticlesByGroAndPage();
	  //test.getRows();
	  //test.testFindByEmail();
	  //test.testListGroupsBySummarize();
	  //test.testGetCorrentArticle();
	  //test.testListArticleByJoinGroupSortByDate();
	  //test.listMessageByUserId();
	  //test.addMessage();
	  //test.addPage();
	  //test.addLink();
	  test.showCycle(5);
  }
  public void showCycle(int size){
	  for(int i=100-1;i>100-size-1;i--){
		  System.out.println(i);
	  }
  }
  public void addLink(){
	  long l1 = System.currentTimeMillis();
	  Date d1 = new Date(l1);
	  System.out.println("begin time:"+d1.toString());
	  for(int i=0;i<1000;i++){
	      LinkStore link = new LinkStore();
	      link.setLink("https://translate.google.com/?sl=en&tl=zh-CN&js=n&prev=_t&hl=zh-CN&ie=UTF-8&eotf=1&text=adopter.#zh-CN/en/%E5%A4%84%E7%90%86");
	      link.setVisited(0);
	      linkDAO.saveLink(link);
	  }
	  long l2 = System.currentTimeMillis();
	  Date d2 = new Date(l2);
	  System.out.println("end time:"+d2);
	  
  }
  public void addPage(){
	   Page page = new Page();
	   String s = "ÄãºÃ";
	   byte[] b = s.getBytes();
	   page.setWebPage(Hibernate.createBlob(b));
	   pageDAO.savePage(page);
  }
  public void addMessage(){
	  Date date = new Date();  
	  Timestamp t = new Timestamp(date.getTime()); 
      
	  User user = new User();
	  user.setId(1);
	  user.setName("wangkang");
	  Message m= new Message();
	  m.setUser(user);
	  m.setDate(t);
	  m.setContent("ÄãºÃ");
	  messageDAO.addMessage(m);
  }
  public void listMessageByUserId(){
	  User user = new User();
	  user.setId(1);
	  List<Message> list = messageDAO.listMessageByUserId(user);
	  for(int i=0;i<list.size();i++){
		  Message m = list.get(i);
		  System.out.println("id:"+m.getId()+",name:"+m.getUser().getName()+",date:"+m.getDate()+",content:"+m.getContent());
	  }
  }
  public void testListArticleByJoinGroupSortByDate(){
	  User user = new User();
	  user.setId(1);
	  List<Article> list = articleDAO.listArticleByJoinGroupSortByDate(user);
	  for(int i=0;i<list.size();i++){
		  Article a = list.get(i);
		  System.out.println("id:"+a.getId()+",title:"+a.getTitle()+",author:"+a.getAuthor()+",date:"+a.getDate());
	  }
  }
  public void testGetCorrentArticle(){
	  Article a = articleDAO.getCorrentArticle(1);
	  System.out.println("Title:"+a.getTitle()+",Author"+a.getAuthor()+",Content"+a.getContent());
  }
  public void testListGroupsBySummarize(){
	  List list = groDAO.listGroupsBySummarize();
	  for(int i=0;i<list.size();i++){
		  Gro gro = (Gro) list.get(i);
		  System.out.println("Name:"+gro.getName()+",Summarize:"+gro.getSummarize());
	  }
  }
  public void testFindByEmail(){
	  List list = userDAO.listUsersByEmail();
	  for(int i=0;i<list.size();i++){
		  User user = (User) list.get(i);
		  System.out.println("userid"+user.getId()+"username"+user.getName()+"userpwd"+user.getPassword()+"useremail"+user.getEmail());
	  }
  }
  public void getRows(){
	  Gro gro = new Gro();
	  gro.setId(1);
	  long rows_num = articleDAO.getRows(gro);
	  System.out.println(rows_num);
  }
  //test query articles by group and page
  public void testqueryArticlesByGroAndPage(){
	  Gro gro = new Gro();
	  gro.setId(1);
	  List<Article> list = articleDAO.queryArticlesByGroAndPage(5,6, gro);
	  for(int i=0;i<list.size();i++){
		  Article a = list.get(i);
		  System.out.println("id:"+a.getId()+" title:"+a.getTitle()+" author:"+a.getAuthor()
				  +" date:"+a.getDate()+" content:"+a.getContent());
	  }
  }
  public void testSaveRegisterUser(){
	  User user = new User();
	  user.setName("name1");
	  user.setPassword("123456");
	  user.setState(1);
	  
	  userDAO.saveRegisterUser(user);
  }
  public void testListUsers(){
	  List<User> list = userDAO.listUsers();
	  for(int i=0;i<list.size();i++){
		  User user = list.get(i);
		  System.out.println("name:"+user.getName()+"pwd:"+user.getPassword()+"state"+user.getState());
	  }
  }
  //add user2 to group3
  public void testAddUserToGroup(){
	  //dao.addUsersGroup(2, 3);
	  //add user3 to group3
	  //dao.addUsersGroup(3, 3);
  }
//add user2 to group3
  public void testAddMiddleUserGroupRelation(){
	  UserGroupStructure ugs = new UserGroupStructure();
	  User user = new User();
	  user.setId(2);
	  Gro gro = new Gro();
	  gro.setId(3);
	  
	  Date now = new Date();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
      String  str= dateFormat.format(now);     
      Timestamp ts = new Timestamp(System.currentTimeMillis());
      ts = Timestamp.valueOf(str); 
	  ugs.setUser(user);
	  ugs.setGro(gro);
	  ugs.setAddDate(ts);
	  
	  ugStructureDao.addMiddleUserGroupRelation(ugs);
  }
  
  public void testListGroupsByUserId(){
	  User user = new User();
	  user.setId(1);
	  List list = groDAO.listGroupsByUserId(user);
	  for(int i = 0;i<list.size();i++){
	      Gro gro = (Gro) list.get(i);
	      System.out.println("group name:"+gro.getName());
	  }
  }
}
