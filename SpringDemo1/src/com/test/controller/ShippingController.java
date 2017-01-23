package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.Person;
import com.test.model.Shipping;
import com.test.model.Transaction;
import com.test.service.ShippingService;
import com.test.validate.ShippingInputValidate;

@Controller
public class ShippingController {

	@Autowired
	ShippingService shippingService;

	@RequestMapping(value = "/saveShippingDetails", method = RequestMethod.POST)
	public String saveShippingDetails(@ModelAttribute Shipping shipping,HttpSession session) {

		if (new ShippingInputValidate().validateInput(shipping)) {
			int id= (int) session.getAttribute("userId");
			shipping.setPersonId(id);
			if (shippingService.persistShippingDetails(shipping)) {
				return "success";
			} else {
				return "error";
			}
		}
		return "error";
	}
	@RequestMapping(value="/saveShippingDetailsByPaypal",method=RequestMethod.POST)
	public String saveShippingDetailsbyPaypal(@ModelAttribute Transaction transaction,HttpSession session){
		//int personId= (int) session.getAttribute("userId");
		Person person=shippingService.getPersonById(1);
		transaction.setPerson(person);
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		transaction.setTransactionTime(dateFormat.format(date));
		if(new ShippingInputValidate().validateInputByPaypal(transaction)){
			if(shippingService.persistShippingDetailsByPaypal(transaction)){
				return "success";
			}else{
				return "error";
			}
		}
		return "error";
	}
}
