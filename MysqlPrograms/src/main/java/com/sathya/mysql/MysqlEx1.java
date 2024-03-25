package com.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlEx1 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/siva", "root", "root");
		System.out.println("connection created with mysql database");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
		preparedStatement.setInt(1, 111);
		preparedStatement.setString(2, "charan");
		preparedStatement.setFloat(3, 1000.2f);
		preparedStatement.addBatch();

		preparedStatement.setInt(1, 222);
		preparedStatement.setString(2, "Virat");
		preparedStatement.setFloat(3, 2000.2f);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 333);
		preparedStatement.setString(2, "kohli");
		preparedStatement.setFloat(3, 3000.2f);
		preparedStatement.addBatch();

		preparedStatement.executeBatch();
		connection.close();
	}

}
