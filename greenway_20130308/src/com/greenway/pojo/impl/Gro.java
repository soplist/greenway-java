package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Gro entity. @author MyEclipse Persistence Tools
 */

public class Gro implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String name;
	private Timestamp buildDate;
	private String summarize;
	private Set userGroupStructures = new HashSet(0);

	// Constructors

	/** default constructor */
	public Gro() {
	}

	/** minimal constructor */
	public Gro(User user, String name, Timestamp buildDate) {
		this.user = user;
		this.name = name;
		this.buildDate = buildDate;
	}

	/** full constructor */
	public Gro(User user, String name, Timestamp buildDate,
			Set userGroupStructures) {
		this.user = user;
		this.name = name;
		this.buildDate = buildDate;
		this.userGroupStructures = userGroupStructures;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getBuildDate() {
		return this.buildDate;
	}

	public void setBuildDate(Timestamp buildDate) {
		this.buildDate = buildDate;
	}

	public Set getUserGroupStructures() {
		return this.userGroupStructures;
	}

	public void setUserGroupStructures(Set userGroupStructures) {
		this.userGroupStructures = userGroupStructures;
	}
	
	public String getSummarize() {
		return summarize;
	}

	public void setSummarize(String summarize) {
		this.summarize = summarize;
	}

}