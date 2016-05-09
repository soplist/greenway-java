package com.greenway.pojo.impl;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Message1 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nickname;
    private String content;
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
