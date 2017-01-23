package com.test.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;

	private int value;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id1")
	private Product product;

	public Rating() {
	}

	public int getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}