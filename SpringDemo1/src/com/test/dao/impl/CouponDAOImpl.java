package com.test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CouponDAO;
import com.test.model.Coupon;

@Repository("couponDAO")
public class CouponDAOImpl implements CouponDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String getCouponValue(Integer couponId) {
		Coupon couponValue=(Coupon) sessionFactory.getCurrentSession().load(Coupon.class, couponId);
		return String.valueOf(couponValue.getCouponValue());
	}

}
