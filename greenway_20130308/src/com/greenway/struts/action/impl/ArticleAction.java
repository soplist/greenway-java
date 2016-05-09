package com.greenway.struts.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gentie;
import com.greenway.pojo.impl.Gro;
import com.greenway.service.inter.IArticleService;
import com.greenway.service.inter.IGentieService;
import com.greenway.util.Pager;
import com.greenway.util.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class ArticleAction extends ActionSupport implements ServletRequestAware{
	
	private javax.servlet.http.HttpServletRequest request;
	
	private IArticleService articleService;
	private IGentieService gentieService;
	

	
	private static final int PGGE_SIZE = 5;
	
	public String listArticleByGroupId(){
		long totalRows;
		//String pagerMethod = request.getParameter("pageMethod");
		Integer groupId;
		//in action by click first previous next last
		if(null == request.getParameter("group_id"))
			groupId = (Integer) request.getSession().getAttribute("group_id");
		//in action by click corrent group
		else{
			groupId = new Integer(request.getParameter("group_id"));
		}
		Gro gro = new Gro();
		gro.setId(groupId);
		totalRows = articleService.getRows(gro);
		Pager pager= PagerHelper.getPager(request,totalRows);
		
	    List<Article> list = articleService.queryArticlesByGroAndPage(PGGE_SIZE,pager.getStartRow(),gro);
		
	    request.getSession().setAttribute("article_list", list);
		request.getSession().setAttribute("group_id", groupId);
		request.getSession().setAttribute("PAGER", pager);
		System.out.println("PAGER set");
		return "list_suc";
	}
	public String getCorrentArticle(){
		Integer articleId = new Integer(request.getParameter("article_id"));
		Article article = articleService.getCorrentArticle(articleId);
		List<Gentie> gentieList = gentieService.listGentieByArticleId(article);
		request.getSession().setAttribute("article", article);
		request.getSession().setAttribute("gentie_list", gentieList);
		return "get_suc";
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		
	}
	public IArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	public IGentieService getGentieService() {
		return gentieService;
	}
	public void setGentieService(IGentieService gentieService) {
		this.gentieService = gentieService;
	}

}
