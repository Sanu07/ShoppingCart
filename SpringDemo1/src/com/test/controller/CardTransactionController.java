package com.test.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.Person;
import com.test.model.Transaction;
import com.test.service.CardTransactionService;

@Controller
public class CardTransactionController {
	@Autowired
	CardTransactionService cardTransactionService;
	
	@RequestMapping(value="/saveTransactionDetails",method=RequestMethod.POST)
	public String saveTransactionDetails(@ModelAttribute Transaction transaction, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "login";
		} else {
			if (transaction.getAmount().trim().length() > 0 && transaction.getTransactionCardexpiryDate() != null
					&& !transaction.getTransactionCardexpiryDate().isEmpty()
					&& transaction.getTransactionCardName() != null && !transaction.getTransactionCardName().isEmpty()
					&& transaction.getTransactionCardType() != null && !transaction.getTransactionCardType().isEmpty()
					&& transaction.getCvv() != null && !transaction.getCvv().isEmpty()) {
				transaction.setTransactionTime(String.valueOf(new Date()));
				Integer id = (int) session.getAttribute("userId");
				Person person = cardTransactionService.getUserById(id);
				transaction.setPerson(person);
				cardTransactionService.saveTransactionDetails(transaction);
				return "success";
			} else {
				return "error";
			}
		}
	}
}
