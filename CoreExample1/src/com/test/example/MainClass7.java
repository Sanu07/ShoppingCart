package com.test.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.EmployeeBean;
import com.test.dao.EmployeeDao;

public class MainClass7 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("dataBase.xml");
		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
/**
 * To insert into employee
 */
		/*
		int i = dao.saveEmployee(new EmployeeBean("Employee C", "Tech Mahindra"));
		System.out.println(i);
		*/
		/**
		 * to update employee
		 */
		/*
		int i=dao.updateEmployee(new EmployeeBean("Employee C","HCL"));
		System.out.println(i);
		*/
		/**
		 * To delete a tuple from employee
		 */
		int i=dao.deleteEmployee(new EmployeeBean("Employee C"));
		System.out.println(i);
	}
}
