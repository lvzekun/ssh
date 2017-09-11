package com.bean;

/**
 * CarBackUp entity. @author MyEclipse Persistence Tools
 */

public class CarBackUp implements java.io.Serializable {

	// Fields

	private String numcar;
	private String player;
	private String time1;
	private String time2;
	private String carid;
	private String parkid;

	// Constructors

	/** default constructor */
	public CarBackUp() {
	}

	/** full constructor */
	public CarBackUp(String numcar, String player, String time1, String time2,
			String carid, String parkid) {
		this.numcar = numcar;
		this.player = player;
		this.time1 = time1;
		this.time2 = time2;
		this.carid = carid;
		this.parkid = parkid;
	}

	// Property accessors

	public String getNumcar() {
		return this.numcar;
	}

	public void setNumcar(String numcar) {
		this.numcar = numcar;
	}

	public String getPlayer() {
		return this.player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getTime1() {
		return this.time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return this.time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getCarid() {
		return this.carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getParkid() {
		return this.parkid;
	}

	public void setParkid(String parkid) {
		this.parkid = parkid;
	}

}