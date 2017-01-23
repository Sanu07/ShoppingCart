package com.test.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the coupon database table.
 * 
 */
@Entity
@NamedQuery(name="Coupon.findAll", query="SELECT c FROM Coupon c")
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int couponId;

	private int couponValue;

	//bi-directional many-to-one association to Transaction
	/*@OneToMany(mappedBy="coupon")
	private Set<Transaction> transactions;*/

	public Coupon() {
	}

	public int getCouponId() {
		return this.couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getCouponValue() {
		return this.couponValue;
	}

	public void setCouponValue(int couponValue) {
		this.couponValue = couponValue;
	}

	/*public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setCoupon(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setCoupon(null);

		return transaction;
	}*/

}