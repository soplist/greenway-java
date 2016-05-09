package com.greenway.pojo.impl;

import java.sql.Blob;



/**
 * Page entity. @author MyEclipse Persistence Tools
 */

public class Page implements java.io.Serializable {

	// Fields

	private Integer id;
	private Blob webPage;

	// Constructors

	/** default constructor */
	public Page() {
	}

	/** full constructor */
	public Page(Blob webPage) {
		this.webPage = webPage;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Blob getWebPage() {
		return this.webPage;
	}

	public void setWebPage(Blob webPage) {
		this.webPage = webPage;
	}

}