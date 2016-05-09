package com.greenway.service.impl;

import java.util.List;

import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gentie;
import com.greenway.pojo.inter.IGentieDAO;
import com.greenway.service.inter.IGentieService;

public class GentieService implements IGentieService {
	private IGentieDAO gentieDAO;
    
	public IGentieDAO getGentieDAO() {
		return gentieDAO;
	}

	public void setGentieDAO(IGentieDAO gentieDAO) {
		this.gentieDAO = gentieDAO;
	}

	public List<Gentie> listGentieByArticleId(Article article) {
		// TODO Auto-generated method stub
		return gentieDAO.listGentieByArticleId(article);
	}

}
