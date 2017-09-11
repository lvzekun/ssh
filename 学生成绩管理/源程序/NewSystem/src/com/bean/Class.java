package com.bean;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {

	// Fields

	private Integer id;
	private String className;

	// Constructors

	/** default constructor */
	public Class() {
	}

	/** full constructor */
	public Class(Integer id, String className) {
		this.id = id;
		this.className = className;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}