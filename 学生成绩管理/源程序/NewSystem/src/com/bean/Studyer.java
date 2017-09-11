package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Studyer entity. @author MyEclipse Persistence Tools
 */

public class Studyer implements java.io.Serializable {

	// Fields

	private String number;
	private String name;
	private String gender;
	private String brithday;
	private String password;
	private String telephone;
	private String addresshome;
	private String classid;
	private Set shs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Studyer() {
	}

	/** minimal constructor */
	public Studyer(String number, String name, String gender, String brithday,
			String password, String telephone, String addresshome,
			String classid) {
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.brithday = brithday;
		this.password = password;
		this.telephone = telephone;
		this.addresshome = addresshome;
		this.classid = classid;
	}

	/** full constructor */
	public Studyer(String number, String name, String gender, String brithday,
			String password, String telephone, String addresshome,
			String classid, Set shs) {
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.brithday = brithday;
		this.password = password;
		this.telephone = telephone;
		this.addresshome = addresshome;
		this.classid = classid;
		this.shs = shs;
	}

	// Property accessors

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number2) {
		this.number = number2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBrithday() {
		return this.brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddresshome() {
		return this.addresshome;
	}

	public void setAddresshome(String addresshome) {
		this.addresshome = addresshome;
	}

	public String getClassid() {
		return this.classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public Set getShs() {
		return this.shs;
	}

	public void setShs(Set shs) {
		this.shs = shs;
	}

}