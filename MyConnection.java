package com.deepsingh44.blogspot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.deepsingh44.blogspot.utility.Util;

public class MyConnection {

	private static Connection con;

	public static Connection getMyConnection() {
		try {
			Properties properties = Util.getMyDatabaseProperty();

			Class.forName(properties.getProperty("classname"));
			con=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (Exception e) {
			Util.log(MyConnection.class, e.toString());
		}
		return con;
	}
}
