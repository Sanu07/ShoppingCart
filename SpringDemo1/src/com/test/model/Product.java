package com.test.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;

	private String discount;

	private String name;

	private double presentValue;

	private double price;
	
	private String imagePath;

	private int quantity;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="product")
	private Set<Comment> comments;

	//bi-directional many-to-one association to Customerorder
	@OneToMany(mappedBy="product")
	private Set<Customerorder> customerorders;

	//bi-directional many-to-many association to Cart
	@ManyToMany
	@JoinTable(
		name="product_has_cart"
		, joinColumns={
			@JoinColumn(name="product_productId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cart_cartId")
			}
		)
	private Set<Cart> carts;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="product")
	private Set<Rating> ratings;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPresentValue() {
		return this.presentValue;
	}

	public void setPresentValue(double presentValue) {
		this.presentValue = presentValue;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProduct(null);

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
		customerorder.setProduct(this);

		return customerorder;
	}

	public Customerorder removeCustomerorder(Customerorder customerorder) {
		getCustomerorders().remove(customerorder);
		customerorder.setProduct(null);

		return customerorder;
	}

	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setProduct(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setProduct(null);

		return rating;
	}

}