package com.greenway.service.inter;

import java.util.List;

import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gentie;

public interface IGentieService {
	public List<Gentie> listGentieByArticleId(Article article);
}
