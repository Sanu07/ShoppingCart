package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.CardTransactionDAO;
import com.test.model.Person;
import com.test.model.Transaction;
import com.test.service.CardTransactionService;
@Service("cardTransactionService")
public class CardTransactionServiceImpl implements CardTransactionService {
	
	@Autowired
	CardTransactionDAO cardTransactionDAO;
	
	@Transactional
	@Override
	public boolean saveTransactionDetails(Transaction transaction) {
		if(cardTransactionDAO.saveTransactionDetails(transaction)){
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional
	@Override
	public Person getUserById(Integer id) {
		return cardTransactionDAO.getUserById(id);
	}
}
