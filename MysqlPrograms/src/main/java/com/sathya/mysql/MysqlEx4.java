package com.sathya.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlEx4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Create the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/siva", "root", "root");
		System.out.println("connection created with mysql database");
		DatabaseMetaData metadata = connection.getMetaData();
		System.out.println(metadata.getDatabaseProductName());
		System.out.println(metadata.getDatabaseProductVersion());
		System.out.println(metadata.getDriverName());
		System.out.println(metadata.getUserName());
		System.out.println(metadata.getURL());
		connection.close();
	}

}
