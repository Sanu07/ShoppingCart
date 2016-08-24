package com.test.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.test.bean.EmployeeBean;

public class EmployeeDao {
private JdbcTemplate jdbcTemplate;

public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
public int saveEmployee(EmployeeBean e){
	String query="insert into employee values('"+e.getName()+"','"+e.getOrg()+"')";
	return jdbcTemplate.update(query);
}
public int updateEmployee(EmployeeBean e){
	String query="update employee set org='"+e.getOrg()+"' where name='"+e.getName()+"'";
	return jdbcTemplate.update(query);
}

public int deleteEmployee(EmployeeBean e) {
	String query="delete from employee where name='"+e.getName()+"'";
	return jdbcTemplate.update(query);
}
}
 
