package com.test.dao;

import com.test.model.Person;
import com.test.model.Transaction;

public interface CardTransactionDAO {

	boolean saveTransactionDetails(Transaction transaction);

	Person getUserById(Integer id);
}
