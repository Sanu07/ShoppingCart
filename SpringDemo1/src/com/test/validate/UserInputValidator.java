package com.test.validate;

import com.test.model.Person;

public class UserInputValidator {

	public boolean validateUser(Person user) {
		if(user!=null){
			if(notNull(user)){
				if(user.getPhoneNumber().length()==10){
					return true;
				}
			}
	}
		return false;
	}

	private boolean notNull(Person user) {
		if(user.getName()!=null && !user.getName().isEmpty()
				&& user.getPassword() !=null && !user.getPassword().isEmpty() 
				&& user.getPhoneNumber() !=null && !user.getPhoneNumber().isEmpty() 
				&& user.getCountry() !=null && !user.getCountry().isEmpty() 
				&& user.getState() !=null && !user.getState().isEmpty() 
				&& user.getCity() !=null && !user.getCity().isEmpty() 
				&& user.getZip() !=null && !user.getZip().isEmpty() 
				){
			return true;
		}else{
		return false;
	}
	}
}
