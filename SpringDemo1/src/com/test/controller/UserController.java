package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.Person;
import com.test.service.UserDetailsService;
import com.test.validate.UserInputValidator;

@Controller
@Scope("session")
public class UserController{

	@Autowired
	UserDetailsService userDetailsService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute Person user) {
		try {
			if (new UserInputValidator().validateUser(user)) {
				userDetailsService.registerUser(user);
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "exceptions";
		}

	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String doLogin(@RequestParam Map<String, String> reqParam,HttpSession session) {
		String userId = reqParam.get("phoneNumberOrEmailId");
		String password = reqParam.get("password");
		boolean status = false;
		if (userId != null && password != null && !userId.isEmpty() && !password.isEmpty()) {
			List<Person> person = userDetailsService.getUser(userId);
			if (person.size() > 0) {
				if ((person.get(0).getEmail().equalsIgnoreCase(userId)
						|| person.get(0).getPhoneNumber().equalsIgnoreCase(userId))
						&& person.get(0).getPassword().equals(password)) {
					session.setAttribute("userId", person.get(0).getPersonId());
					session.setAttribute("name", person.get(0).getName());
					session.setAttribute("phone", person.get(0).getPhoneNumber());
					session.setAttribute("email", person.get(0).getEmail());
					status = true;
				}
			}
		}
		if (status) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/updateUserProfile", method = RequestMethod.POST)
	public ModelAndView updateUserProfile(@ModelAttribute Person user) {
		ModelAndView modelAndView = new ModelAndView("success");
		if(new UserInputValidator().validateUser(user)){
		userDetailsService.updateUserProfile(user);
		}
		String message = "User Profile successfully Updated";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
