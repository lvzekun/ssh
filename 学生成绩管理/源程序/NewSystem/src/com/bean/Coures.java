package com.bean;

/**
 * Coures entity. @author MyEclipse Persistence Tools
 */

public class Coures implements java.io.Serializable {

	// Fields

	private String id;
	private String couresName;
	private String cnature;
	private Integer credit;

	// Constructors

	/** default constructor */
	public Coures() {
	}

	/** full constructor */
	public Coures(String id, String couresName, String cnature, Integer credit) {
		this.id = id;
		this.couresName = couresName;
		this.cnature = cnature;
		this.credit = credit;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCouresName() {
		return this.couresName;
	}

	public void setCouresName(String couresName) {
		this.couresName = couresName;
	}

	public String getCnature() {
		return this.cnature;
	}

	public void setCnature(String cnature) {
		this.cnature = cnature;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

}