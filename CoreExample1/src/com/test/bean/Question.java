package com.test.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {
private int id;
private String question;
private Map<Object,Object> map=new HashMap<Object,Object>();
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public Map<Object, Object> getMap() {
	return map;
}
public void setMap(Map<Object, Object> map) {
	this.map = map;
}
public void display(){
		Set<Entry<Object, Object>> set=map.entrySet();  
	    Iterator<Entry<Object, Object>> itr=set.iterator();  
	    while(itr.hasNext()){  
	        Entry<Object, Object> entry=itr.next();  
	        User user=(User) entry.getKey();  
	        Address address=(Address) entry.getValue();  
	        System.out.println("User Id : ");
	        System.out.println(user);
	        System.out.println("Address");
	        System.out.println(address.getCountry()+" : "+address.getCity()+" : "+address.getZipCode());
	    }  
	}
}
