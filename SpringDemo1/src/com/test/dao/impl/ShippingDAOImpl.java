package com.test.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.ShippingDAO;
import com.test.model.Person;
import com.test.model.Shipping;
import com.test.model.Transaction;

@Repository("shippingDAO")
public class ShippingDAOImpl implements ShippingDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean persistShippingDetails(Shipping shipping) {
		sessionFactory.getCurrentSession().save(shipping);
		return true;
	}

	@Override
	public Shipping getShippingDetailsbyShippingId(Integer shippingId) {
		Shipping shippingDetails=(Shipping)sessionFactory.getCurrentSession().load(Shipping.class, shippingId);
		return shippingDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipping> getAllShippingDetails() {
		List<Shipping> shippingList = sessionFactory.getCurrentSession().createQuery("from Shipping").list();
		return shippingList;
	}

	@Override
	public Shipping getShippingDetailsbyPersonId(Integer personId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.getNamedQuery("Shipping.findPersonByEmail");
		Shipping shippingDetails=(Shipping) query.uniqueResult();
		return shippingDetails;
	}

	@Override
	public Person getPersonById(Integer personId) {
		Session session=sessionFactory.getCurrentSession();
		return (Person) session.load(Person.class, personId);
	}

	@Override
	public boolean persistShippingDetailsByPaypal(Transaction transaction) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(transaction);
		return true;
	}

}
