package com.bean;

/**
 * ShId entity. @author MyEclipse Persistence Tools
 */

public class ShId implements java.io.Serializable {

	// Fields

	private Studyer studyer;
	private Coures coures;

	// Constructors

	/** default constructor */
	public ShId() {
	}

	/** full constructor */
	public ShId(Studyer studyer, Coures coures) {
		this.studyer = studyer;
		this.coures = coures;
	}

	// Property accessors

	public Studyer getStudyer() {
		return this.studyer;
	}

	public void setStudyer(Studyer studyer) {
		this.studyer = studyer;
	}

	public Coures getCoures() {
		return this.coures;
	}

	public void setCoures(Coures coures) {
		this.coures = coures;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShId))
			return false;
		ShId castOther = (ShId) other;

		return ((this.getStudyer() == castOther.getStudyer()) || (this
				.getStudyer() != null && castOther.getStudyer() != null && this
				.getStudyer().equals(castOther.getStudyer())))
				&& ((this.getCoures() == castOther.getCoures()) || (this
						.getCoures() != null && castOther.getCoures() != null && this
						.getCoures().equals(castOther.getCoures())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudyer() == null ? 0 : this.getStudyer().hashCode());
		result = 37 * result
				+ (getCoures() == null ? 0 : this.getCoures().hashCode());
		return result;
	}

}