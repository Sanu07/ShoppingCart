package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.UserDAO;
import com.test.model.Person;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(Person user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Person getUserByLoginId(Integer loginId) {
		return (Person) sessionFactory.getCurrentSession().getNamedQuery("getUser").setInteger("loginId", loginId)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllUsers() {
		//return sessionFactory.getCurrentSession().getNamedQuery("getAllUsers").list();
		return null;
	}

	@Override
	public void updateUserProfile(Person user) {
		//User userToUpdate = (User) getUser(2);
		//userToUpdate.setPhoneNumber(user.getPhoneNumber());
		//userToUpdate.setEmailId(user.getEmailId());
		//userToUpdate.setPassword(user.getPassword());
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		}

	/* (non-Javadoc)
	 * @see com.test.dao.UserDAO#getUser(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getUser(String id) {
		return  sessionFactory.getCurrentSession().getNamedQuery("getUser").setString("email", id)
				.setString("phoneNumber", id)
				.list();
	}

}
