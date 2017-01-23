package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Coupon;
import com.test.service.CouponService;

@Controller
public class CouponController {

	@Autowired
	CouponService couponService;
	@RequestMapping(value="/applyingCoupon",method=RequestMethod.POST)
	public @ResponseBody String getCouponValue(@RequestParam("couponId") String couponId){
   	return couponService.getCouponValue(Integer.parseInt(couponId));
	}
}
