package com.test.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;

	private String amount;

	private String transactionCardexpiryDate;

	private String transactionCardName;

	private String transactionCardType;

	private String transactionTime;

	private String cvv;
	//bi-directional many-to-one association to Coupon
	/*@ManyToOne
	private Coupon coupon;
*/
	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Transaction() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransactionCardexpiryDate() {
		return this.transactionCardexpiryDate;
	}

	public void setTransactionCardexpiryDate(String transactionCardexpiryDate) {
		this.transactionCardexpiryDate = transactionCardexpiryDate;
	}

	public String getTransactionCardName() {
		return this.transactionCardName;
	}

	public void setTransactionCardName(String transactionCardName) {
		this.transactionCardName = transactionCardName;
	}

	public String getTransactionCardType() {
		return this.transactionCardType;
	}

	public void setTransactionCardType(String transactionCardType) {
		this.transactionCardType = transactionCardType;
	}

	public String getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	/*public Coupon getCoupon() {
		return this.coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}*/

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}