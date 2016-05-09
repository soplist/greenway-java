package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.greenway.pojo.inter.IContent;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Message implements java.io.Serializable,IContent {
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private User user;
	private Timestamp date;
	private String content;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(User user, Timestamp date) {
		this.user = user;
		this.date = date;
	}

	/** full constructor */
	public Message(User user, Timestamp date, String content) {
		this.user = user;
		this.date = date;
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

	public Timestamp getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fd = df.format(date);
		java.sql.Timestamp ts = java.sql.Timestamp.valueOf(fd);
		return ts;
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

}