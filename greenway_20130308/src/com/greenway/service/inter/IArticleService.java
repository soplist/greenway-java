package com.greenway.service.inter;

import java.util.List;

import org.hibernate.HibernateException;

import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gro;
import com.greenway.pojo.impl.User;

public interface IArticleService {
	public List getArticleByGroupID(Object gro);
	
	public List queryArticlesByGroAndPage(int pageSize,int startRow,Gro gro);
	
	public long getRows(Gro gro) throws HibernateException;
	
	public Article getCorrentArticle(Integer id);
	
	public List<Article> listArticleByJoinGroupSortByDate(User user);
}
