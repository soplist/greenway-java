package com.greenway.pojo.impl;

/**
 * Pic entity. @author MyEclipse Persistence Tools
 */

public class Pic implements java.io.Serializable {

	// Fields

	private Integer idpic;
	private String caption;
	private String img;

	// Constructors

	/** default constructor */
	public Pic() {
	}

	/** full constructor */
	public Pic(String caption, String img) {
		this.caption = caption;
		this.img = img;
	}

	// Property accessors

	public Integer getIdpic() {
		return this.idpic;
	}

	public void setIdpic(Integer idpic) {
		this.idpic = idpic;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}