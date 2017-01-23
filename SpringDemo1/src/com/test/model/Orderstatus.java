package com.test.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Orderstatus.findAll", query="SELECT o FROM Orderstatus o")
public class Orderstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderstatusId;

	private String description;

	private String status;

	//bi-directional many-to-one association to Customerorder
	@ManyToOne
	private Customerorder customerorder;

	public Orderstatus() {
	}

	public int getOrderstatusId() {
		return this.orderstatusId;
	}

	public void setOrderstatusId(int orderstatusId) {
		this.orderstatusId = orderstatusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customerorder getCustomerorder() {
		return this.customerorder;
	}

	public void setCustomerorder(Customerorder customerorder) {
		this.customerorder = customerorder;
	}

}