package com.test.service;

import com.test.model.Person;
import com.test.model.Transaction;

public interface CardTransactionService {

	/**
	 * by default they are public methods
	 * @param transaction
	 */
	boolean saveTransactionDetails(Transaction transaction);
	Person getUserById(Integer id);
}
