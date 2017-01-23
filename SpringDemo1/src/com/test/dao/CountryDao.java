package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.util.DBManager;

public class CountryDao {

	public List<String> getStates(String getItem) {
		Connection connection;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection=DBManager.getConnection();
		List<String> list=new ArrayList<String>();
		try {
			preparedStatement=connection.prepareStatement("select statename from country where countryname='"+getItem+"'");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			preparedStatement.close();
			resultSet.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<String> getCity(String getItem) {
		Connection connection;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection=DBManager.getConnection();
		List<String> list=new ArrayList<String>();
		try {
			preparedStatement=connection.prepareStatement("select cityname from country where statename='"+getItem+"'");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			preparedStatement.close();
			resultSet.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<String> getZip(String getItem) {
		Connection connection;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection=DBManager.getConnection();
		List<String> list=new ArrayList<String>();
		try {
			preparedStatement=connection.prepareStatement("select zipcode from country where cityname='"+getItem+"'");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			preparedStatement.close();
			resultSet.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
