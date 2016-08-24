package com.test.example;



import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.test.bean.BeanClass;

public class MainClass {
public static void main(String[] args) {
	Resource resource=(Resource) new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory((org.springframework.core.io.Resource) resource);  
	      
	    BeanClass student=(BeanClass)factory.getBean("bean1");  
	    student.displayInfo();
}
}

