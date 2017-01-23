package com.test.service;

import java.util.List;

import com.test.model.Person;


public interface UserDetailsService {
	public Person getUserByLoginId(Integer loginId);
	public boolean registerUser(Person user);
	public List<Person> getAllUsers();
	public void updateUserProfile(Person user);
	public List<Person> getUser(String loginId);
}
