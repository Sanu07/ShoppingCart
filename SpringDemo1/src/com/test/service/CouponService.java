package com.test.service;

import org.springframework.stereotype.Service;

import com.test.model.Coupon;

@Service
public interface CouponService {

	public String getCouponValue(Integer couponId);

}
