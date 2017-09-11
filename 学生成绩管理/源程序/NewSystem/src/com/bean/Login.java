package com.bean;

/**
 * Login entity. @author MyEclipse Persistence Tools
 */

public class Login implements java.io.Serializable {

	// Fields

	private String username;
	private Integer id;
	private String password;

	// Constructors

	/** default constructor */
	public Login() {
	}

	/** full constructor */
	public Login(String username, Integer id, String password) {
		this.username = username;
		this.id = id;
		this.password = password;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}