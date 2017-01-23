package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.CouponDAO;
import com.test.model.Coupon;
import com.test.service.CouponService;
@Service("couponService")
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CouponDAO couponDAO;
	
	@Transactional
	@Override
	public String getCouponValue(Integer couponId) {
		return couponDAO.getCouponValue(couponId);
	}

}
