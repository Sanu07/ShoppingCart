package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

public static Connection getConnection(){
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingtemp","root","root");
	} catch (ClassNotFoundException e) {
		
	System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}  
	return con;
	
}
}
