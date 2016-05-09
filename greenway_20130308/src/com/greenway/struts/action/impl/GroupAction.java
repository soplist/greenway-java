package com.greenway.struts.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gro;
import com.greenway.pojo.impl.User;
import com.greenway.service.inter.IArticleService;
import com.greenway.service.inter.IGroupService;
import com.greenway.service.inter.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class GroupAction extends ActionSupport implements ServletRequestAware{
	
	private javax.servlet.http.HttpServletRequest request;
	
	private IGroupService groupService;
	
	private IArticleService articleService;
	
	@Override
	public String execute() throws Exception
    {
        return "";
    }
	public String getGroupsByUserId(){
		Integer user_id =  new Integer(request.getParameter("user_id"));
		User user = new User();
		user.setId(user_id);
		List<Gro> groupList = groupService.listGroupsByUserId(user);
		List<Article> articleList = articleService.listArticleByJoinGroupSortByDate(user);
		request.getSession().setAttribute("group_list", groupList);
		request.getSession().setAttribute("article_list", articleList);
		return "list_group_success";
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public IGroupService getGroupService() {
		return groupService;
	}
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	public IArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
}
