package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	public int save(User user) {
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into user_details values(?,?,?,?,?)");) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setLong(4, user.getMobile());
			preparedStatement.setString(5, user.getAddress());

			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public int findDetails(String Username, String Password) {
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select name , password from user_details where name=? and password =? ");) {
			preparedStatement.setString(1, Username);
			preparedStatement.setString(2, Password);

			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public String getEmail(String userName) {
		String email=null;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select email from user_details where name=?");) {
			preparedStatement.setString(1, userName);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			email=resultSet.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}
}
