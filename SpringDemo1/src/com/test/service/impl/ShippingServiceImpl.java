package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ShippingDAO;
import com.test.model.Person;
import com.test.model.Shipping;
import com.test.model.Transaction;
import com.test.service.ShippingService;

@Service("shippingDetailsService")
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	ShippingDAO shippingDAO;

	@Transactional
	@Override
	public boolean persistShippingDetails(Shipping shipping) {
		return shippingDAO.persistShippingDetails(shipping);
	}

	@Transactional
	@Override
	public Shipping getShippingDetailsbyShippingId(Integer shippingId) {
		return shippingDAO.getShippingDetailsbyShippingId(shippingId);
	}

	@Transactional
	@Override
	public List<Shipping> getAllShippingDetails() {
		return shippingDAO.getAllShippingDetails();
	}

	@Transactional
	@Override
	public Shipping getShippingDetailsbyPersonId(Integer personId) {
		return shippingDAO.getShippingDetailsbyPersonId(personId);
	}

	@Transactional
	@Override
	public Person getPersonById(Integer personId) {
		return shippingDAO.getPersonById(personId);
	}

	@Transactional
	@Override
	public boolean persistShippingDetailsByPaypal(Transaction transaction) {
		return shippingDAO.persistShippingDetailsByPaypal(transaction);
	}

}
