package com.test.bean;

public class AddressConstructor {
private String country;
private String state;
private int zipCode;
private int stateId;
public AddressConstructor(String country, String state, int zipCode, int stateId) {
	super();
	this.country = country;
	this.state = state;
	this.zipCode = zipCode;
	this.stateId = stateId;
}
@Override
public String toString() {
	return "AddressConstructor [country=" + country + ", state=" + state + ", zipCode=" + zipCode + ", stateId="
			+ stateId + "]";
}

}
