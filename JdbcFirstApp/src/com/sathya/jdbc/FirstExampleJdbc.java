package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstExampleJdbc 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//Step-1 load the driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Load Driver SuccessFull...");
		
		//step-2 make a connection
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","rajesh","rajesh");
		System.out.println("connection successful");
		
		//step-4:close the connection
		
		connection.close();
		System.out.println("connection close succesfull");
		
	}

}


