package com.greenway.pojo.impl;

import java.sql.Timestamp;
@SuppressWarnings("serial")
public class PostMessage implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private User user;
	private Timestamp date;
	private String content;
}
