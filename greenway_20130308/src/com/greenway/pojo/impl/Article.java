package com.greenway.pojo.impl;

import java.sql.Timestamp;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private Integer id;
	private Gro gro;
	private String title;
	private String author;
	private Timestamp date;
	private String content;
	private Integer state;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Gro gro, String title, String author, Timestamp date,
			Integer state) {
		this.gro = gro;
		this.title = title;
		this.author = author;
		this.date = date;
		this.state = state;
	}

	/** full constructor */
	public Article(Gro gro, String title, String author, Timestamp date,
			String content, Integer state) {
		this.gro = gro;
		this.title = title;
		this.author = author;
		this.date = date;
		this.content = content;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Gro getGro() {
		return this.gro;
	}

	public void setGro(Gro gro) {
		this.gro = gro;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}