package com.test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CardTransactionDAO;
import com.test.model.Person;
import com.test.model.Transaction;
@Repository("cardTransactionDAO")
public class CardTransactionDAOImpl implements CardTransactionDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveTransactionDetails(Transaction transaction) {
		sessionFactory.getCurrentSession().saveOrUpdate(transaction);
		return true;
	}

	@Override
	public Person getUserById(Integer id) {
		return (Person) sessionFactory.getCurrentSession().load(Person.class, id);
	}

}
