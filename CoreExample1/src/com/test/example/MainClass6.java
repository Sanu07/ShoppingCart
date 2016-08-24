package com.test.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.FactoryBean;

public class MainClass6 {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
	FactoryBean bean=(FactoryBean)context.getBean("factoryBean");
bean.msg();
}
}
