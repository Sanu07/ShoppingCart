package com.test.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String cityname;

	private String countryname;

	private String statename;

	private String zipcode;

	public Country() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCountryname() {
		return this.countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getStatename() {
		return this.statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}