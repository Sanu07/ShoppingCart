package com.test.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.EmployeeBean;

public class MainClass2 {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeBean emp=(EmployeeBean) context.getBean("employee");
//	System.out.println("Name : "+emp.getName()+"\nOrganisation : "+emp.getOrg()+
//			"\nCountry : "+emp.getAddress().getCountry()+"\nCity : "+emp.getAddress().getCity()
//			+"\nZip Code : "+emp.getAddress().getZipCode());
}
}
