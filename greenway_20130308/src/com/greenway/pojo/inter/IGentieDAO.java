package com.greenway.pojo.inter;

import java.util.List;

import com.greenway.pojo.impl.Article;
import com.greenway.pojo.impl.Gentie;

public interface IGentieDAO {
	public List<Gentie> listGentieByArticleId(Article article);

}
