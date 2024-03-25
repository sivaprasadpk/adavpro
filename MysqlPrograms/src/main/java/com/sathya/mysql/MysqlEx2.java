package com.sathya.mysql;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlEx2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/siva", "root", "root");
		// making the Resultset scrollable & Update
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		// execute the select query & store the data in resultset
		ResultSet set = statement.executeQuery("select * from emp");
		// Reading all records Backword directions
		set.afterLast();
		while (set.previous()) {
		System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getFloat(3));
		// cursor is pionting to specific record
		}
		set.absolute(2);
		System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getFloat(3));
	
	}
	}


