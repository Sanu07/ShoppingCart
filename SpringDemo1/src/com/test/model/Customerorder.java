package com.test.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the customerorder database table.
 * 
 */
@Entity
@NamedQuery(name="Customerorder.findAll", query="SELECT c FROM Customerorder c")
public class Customerorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerOrderId;

	private double amount;

	private Timestamp dateCreated;

	private String productDescription;

	private String quantity;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to Orderstatus
	@OneToMany(mappedBy="customerorder")
	private Set<Orderstatus> orderstatuses;

	public Customerorder() {
	}

	public int getCustomerOrderId() {
		return this.customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public Set<Orderstatus> getOrderstatuses() {
		return this.orderstatuses;
	}

	public void setOrderstatuses(Set<Orderstatus> orderstatuses) {
		this.orderstatuses = orderstatuses;
	}

	public Orderstatus addOrderstatus(Orderstatus orderstatus) {
		getOrderstatuses().add(orderstatus);
		orderstatus.setCustomerorder(this);

		return orderstatus;
	}

	public Orderstatus removeOrderstatus(Orderstatus orderstatus) {
		getOrderstatuses().remove(orderstatus);
		orderstatus.setCustomerorder(null);

		return orderstatus;
	}

}