package com.greenway.pojo.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private Integer state;
	private String email;
	private String dscrb;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Set gros = new HashSet(0);
	private Set userGroupStructures = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password, Integer state, String email,String dscrb) {
		this.name = name;
		this.password = password;
		this.state = state;
		this.email = email;
		this.dscrb = dscrb;
	}

	/** full constructor */
	public User(String name, String password, Integer state,String email, Set gros,
			Set userGroupStructures) {
		this.name = name;
		this.password = password;
		this.state = state;
		this.email = email;
		this.gros = gros;
		this.userGroupStructures = userGroupStructures;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	 
	public Set getGros() {
		return this.gros;
	}
    
	public void setGros(Set gros) {
		this.gros = gros;
	}

	public Set getUserGroupStructures() {
		return this.userGroupStructures;
	}

	public void setUserGroupStructures(Set userGroupStructures) {
		this.userGroupStructures = userGroupStructures;
	}
	public String getDscrb() {
		return dscrb;
	}

	public void setDscrb(String dscrb) {
		this.dscrb = dscrb;
	}

}