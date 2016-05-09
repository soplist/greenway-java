package com.greenway.pojo.impl;

import java.sql.Timestamp;

/**
 * Gentie entity. @author MyEclipse Persistence Tools
 */

public class Gentie implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Article article;
	private Timestamp addDate;
	private String content;

	// Constructors

	
	/** default constructor */
	public Gentie() {
	}

	/** full constructor */
	public Gentie(User user, Article article, Timestamp addDate,String content) {
		this.user = user;
		this.article = article;
		this.addDate = addDate;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}