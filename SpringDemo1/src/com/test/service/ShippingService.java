package com.test.service;

import java.util.List;

import com.test.model.Person;
import com.test.model.Shipping;
import com.test.model.Transaction;

public interface ShippingService {
	public boolean persistShippingDetails(Shipping shipping);
	public Shipping getShippingDetailsbyShippingId(Integer shippingId);
	public List<Shipping> getAllShippingDetails();
	public Person getPersonById(Integer personId);
	public boolean persistShippingDetailsByPaypal(Transaction transaction);
	public Shipping getShippingDetailsbyPersonId(Integer personId);
}
