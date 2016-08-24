package com.test.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.NumberUtils;

public class Solution {
	public static void main(String[] args) {
	System.out.println(main());	
	}

    public static String main() {
    	List<String> list=new ArrayList<String>();
    	list.add("Sanu");
    	list.add("test");
     boolean status;
    	list.forEach(l ->  {
    		if(l.equals("test")){
    			
    			
    		}else{
    			System.out.println("false "+l);
    		}
    	});
    	return "hello";
    }
}