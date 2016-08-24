package com.test.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.AddressConstructor;

public class MainClass3 {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	AddressConstructor constructor=(AddressConstructor) context.getBean("addressConstructor");
	System.out.println(constructor);
}
}
