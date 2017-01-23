package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDAO;
import com.test.model.Person;
import com.test.service.UserDetailsService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDAO userDAO;

	@Transactional
	@Override
	public boolean registerUser(Person user) {
		userDAO.registerUser(user);
		return true;
	}

	@Transactional
	@Override
	public Person getUserByLoginId(Integer loginId) {
		// TODO Auto-generated method stub
		return userDAO.getUserByLoginId(loginId);
	}

	@Transactional
	@Override
	public List<Person> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	@Override
	public void updateUserProfile(Person user) {
		userDAO.updateUserProfile(user);
	}

	@Transactional
	@Override
	public List<Person> getUser(String loginId) {
		return userDAO.getUser(loginId);

	}
}
