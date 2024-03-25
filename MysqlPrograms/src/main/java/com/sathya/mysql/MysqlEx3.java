package com.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class MysqlEx3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Create the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/siva", "root", "root");
		// create a statement
		Statement statement = connection.createStatement();
		// Execute a statement object & store data in resultset object
		ResultSet set = statement.executeQuery("select * from emp");
		// Create a Resultset Metadata object
		ResultSetMetaData metaData = set.getMetaData();

		System.out.println(metaData.getColumnCount());
		System.out.println(metaData.getColumnName(2));
		System.out.println(metaData.getColumnTypeName(2));
		System.out.println(metaData.getColumnDisplaySize(2));

		connection.close();
	}

}
