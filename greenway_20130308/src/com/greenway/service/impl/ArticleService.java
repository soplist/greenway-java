package com.greenway.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import com.greenway.pojo.inter.IArticleDAO;
import com.greenway.service.inter.IArticleService;
import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gro;
import com.greenway.pojo.impl.User;

public class ArticleService implements IArticleService {
    private IArticleDAO articleDAO;
	public List<Article> getArticleByGroupID(Object gro) {
		// TODO Auto-generated method stub
		List<Article> list = articleDAO.findByGro(gro);
		if(list.size() == 0)
			 return null;
		else
		     return list;
	}
	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}
	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	public List queryArticlesByGroAndPage(int pageSize, int startRow, Gro gro) {
		// TODO Auto-generated method stub
		return articleDAO.queryArticlesByGroAndPage(pageSize, startRow, gro);
	}
	public long getRows(Gro gro) throws HibernateException {
		// TODO Auto-generated method stub
		return articleDAO.getRows(gro);
	}
	public Article getCorrentArticle(Integer id) {
		// TODO Auto-generated method stub
		return articleDAO.getCorrentArticle(id);
	}
	public List<Article> listArticleByJoinGroupSortByDate(User user) {
		// TODO Auto-generated method stub
		return articleDAO.listArticleByJoinGroupSortByDate(user);
	}
    
}
