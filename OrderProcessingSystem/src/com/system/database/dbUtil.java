package com.system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil {
	private static Connection con;
	
	public static Connection getConnection() {
		if(con == null) {
			String url = "jdbc:mysql://localhost:3306/OrderProcessingDB";
			String username = "root";
			String password = "root";
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				con = DriverManager.getConnection(url,username,password);
				return con;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
