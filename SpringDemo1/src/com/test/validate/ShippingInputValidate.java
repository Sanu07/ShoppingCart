package com.test.validate;

import com.test.model.Shipping;
import com.test.model.Transaction;

public class ShippingInputValidate {

	public boolean validateInput(Shipping shipping) {
		if(shipping.getName()!=null && !shipping.getName().isEmpty()
				&& shipping.getEmail()!=null && !shipping.getEmail().isEmpty()
				&& shipping.getPhoneNumber()!=null && !shipping.getPhoneNumber().isEmpty()
				&& shipping.getAddress()!=null && !shipping.getAddress().isEmpty()
				&& shipping.getCountry()!=null && !shipping.getCountry().isEmpty()
				&& shipping.getState()!=null && !shipping.getState().isEmpty()
				&& shipping.getCity()!=null && !shipping.getCity().isEmpty()
				&& shipping.getZip()!=null && !shipping.getZip().isEmpty()){
			return true;
		}else{
		return false;	
		}
	}

	public boolean validateInputByPaypal(Transaction transaction) {
		if(transaction.getTransactionCardName()!=null && !transaction.getTransactionCardName().isEmpty()
				&& transaction.getTransactionCardType()!=null && !transaction.getTransactionCardType().isEmpty() 
				&& transaction.getTransactionCardexpiryDate()!=null && !transaction.getTransactionCardexpiryDate().isEmpty()
				&& transaction.getTransactionTime()!=null && !transaction.getTransactionTime().isEmpty()
				&& transaction.getCvv()!=null && !transaction.getCvv().isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
