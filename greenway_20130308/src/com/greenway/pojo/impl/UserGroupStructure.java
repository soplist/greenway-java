package com.greenway.pojo.impl;

import java.sql.Timestamp;

/**
 * UserGroupStructure entity. @author MyEclipse Persistence Tools
 */

public class UserGroupStructure implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Gro gro;
	private Timestamp addDate;

	// Constructors

	/** default constructor */
	public UserGroupStructure() {
	}

	/** full constructor */
	public UserGroupStructure(User user, Gro gro, Timestamp addDate) {
		this.user = user;
		this.gro = gro;
		this.addDate = addDate;
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

	public Gro getGro() {
		return this.gro;
	}

	public void setGro(Gro gro) {
		this.gro = gro;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

}