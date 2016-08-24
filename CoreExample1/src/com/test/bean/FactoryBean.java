package com.test.bean;

public class FactoryBean {
private static final FactoryBean obj=new FactoryBean();
public FactoryBean(){
	System.out.println("Default Constructor");
}
public static FactoryBean getFactoryBean(){
	System.out.println("Factory Method");
	return obj;
}
public void msg(){
	System.out.println("Hello Message");
}
}
