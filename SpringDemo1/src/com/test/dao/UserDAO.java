package com.test.dao;

import java.util.List;

import com.test.model.Person;


public interface UserDAO {
	public boolean registerUser(Person user);
	public Person getUserByLoginId(Integer loginId);
	public List<Person> getAllUsers();
	public void updateUserProfile(Person user);
	public List<Person> getUser(String loginId);
}
