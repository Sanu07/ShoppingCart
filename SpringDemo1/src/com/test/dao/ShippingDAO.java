package com.test.dao;

import java.util.List;

import com.test.model.Person;
import com.test.model.Shipping;
import com.test.model.Transaction;


public interface ShippingDAO {
	public boolean persistShippingDetails(Shipping shipping);
	public Shipping getShippingDetailsbyShippingId(Integer shippingId);
	public List<Shipping> getAllShippingDetails();
	public Shipping getShippingDetailsbyPersonId(Integer personId);
	public Person getPersonById(Integer personId);
	public boolean persistShippingDetailsByPaypal(Transaction transaction);
}
