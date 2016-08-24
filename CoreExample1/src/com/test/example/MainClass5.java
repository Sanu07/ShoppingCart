package com.test.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.AutowiringExample;

public class MainClass5 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		AutowiringExample autowiringExample = (AutowiringExample) context.getBean("addressAutoWire");
		System.out.println(autowiringExample.getAddress1().getCity() + " : "
				+ autowiringExample.getAddress1().getCountry() + " : " + autowiringExample.getAddress1().getZipCode());
		System.out.println(autowiringExample.getAddress2().getCity() + " : "
				+ autowiringExample.getAddress2().getCountry() + " : " + autowiringExample.getAddress2().getZipCode());
	}
}
