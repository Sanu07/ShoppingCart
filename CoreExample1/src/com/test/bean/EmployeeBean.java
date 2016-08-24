package com.test.bean;

public class EmployeeBean {
private String name;
private String org;



public EmployeeBean() {
	super();
}
public EmployeeBean(String name, String org) {
	super();
	this.name = name;
	this.org = org;
}

public EmployeeBean(String name) {
	super();
	this.name = name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getOrg() {
	return org;
}
public void setOrg(String org) {
	this.org = org;
}

}
