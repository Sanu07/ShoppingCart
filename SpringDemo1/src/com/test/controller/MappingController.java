package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "index";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCartPage() {
		return "cart";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String getCheckoutPage() {
		return "checkout";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String getBlogPage() {
		return "blog";
	}

	@RequestMapping(value = "/blog-single", method = RequestMethod.GET)
	public String getBlogSinglePage() {
		return "blog-single";
	}

	@RequestMapping(value = "/contact-us", method = RequestMethod.GET)
	public String getContactUsPage() {
		return "contact-us";
	}

	@RequestMapping(value = "/product-details", method = RequestMethod.GET)
	public String getProductDetailsPage() {
		return "product-details";
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String getShopPage() {
		return "shop";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String getErrorPage() {
		return "404";
	}

	@RequestMapping(value = "/admin-login-error", method = RequestMethod.GET)
	public String getAdminSuccessPage(ModelMap modelMap) {
		return "admin-login-error";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public String getAdminLoginPage(ModelMap modelMap) {
		return "admin-login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String LogoutPage() {
		return "index";
	}
}
