package com.test.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@NamedQueries(
		{
			@NamedQuery(
					name="getUser",
					query="select p from Person p where p.email=:email or p.phoneNumber=:phoneNumber"
					)
		}
		)
/**
 * The persistent class for the person database table.
 * 
 */
@Entity
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int personId;
	
	private String city;

	private String country;

	private String email;

	private String name;

	private String password;

	private String phoneNumber;

	private String role;

	private String state;

	private String zip;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="person")
	private Set<Cart> carts;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="person")
	private Set<Comment> comments;

	//bi-directional many-to-one association to Customerorder
	@OneToMany(mappedBy="person")
	private Set<Customerorder> customerorders;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="person")
	private Set<Rating> ratings;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="person")
	private Set<Transaction> transactions;

	public Person() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setPerson(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setPerson(null);

		return cart;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setPerson(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setPerson(null);

		return comment;
	}

	public Set<Customerorder> getCustomerorders() {
		return this.customerorders;
	}

	public void setCustomerorders(Set<Customerorder> customerorders) {
		this.customerorders = customerorders;
	}

	public Customerorder addCustomerorder(Customerorder customerorder) {
		getCustomerorders().add(customerorder);
		customerorder.setPerson(this);

		return customerorder;
	}

	public Customerorder removeCustomerorder(Customerorder customerorder) {
		getCustomerorders().remove(customerorder);
		customerorder.setPerson(null);

		return customerorder;
	}

	public Set<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setPerson(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setPerson(null);

		return rating;
	}

	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setPerson(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setPerson(null);

		return transaction;
	}

}