package com.greenway.pojo.impl;

import java.sql.Timestamp;

/**
 * LinkStore entity. @author MyEclipse Persistence Tools
 */

public class LinkStore implements java.io.Serializable {

	// Fields

	private Integer id;
	private String link;
	private Integer visited;
	private Timestamp visitedTime;

	// Constructors

	/** default constructor */
	public LinkStore() {
	}

	/** minimal constructor */
	public LinkStore(String link, Integer visited) {
		this.link = link;
		this.visited = visited;
	}

	/** full constructor */
	public LinkStore(String link, Integer visited, Timestamp visitedTime) {
		this.link = link;
		this.visited = visited;
		this.visitedTime = visitedTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getVisited() {
		return this.visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Timestamp getVisitedTime() {
		return this.visitedTime;
	}

	public void setVisitedTime(Timestamp visitedTime) {
		this.visitedTime = visitedTime;
	}

}