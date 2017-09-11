package com.bean;

/**
 * Sh entity. @author MyEclipse Persistence Tools
 */

public class Sh implements java.io.Serializable {

	// Fields

	private ShId id;
	private Integer credit;

	// Constructors

	/** default constructor */
	public Sh() {
	}

	/** full constructor */
	public Sh(ShId id, Integer credit) {
		this.id = id;
		this.credit = credit;
	}

	// Property accessors

	public ShId getId() {
		return this.id;
	}

	public void setId(ShId id) {
		this.id = id;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Sh [id=" + id + ", credit=" + credit + "]";
	}
	
	
}