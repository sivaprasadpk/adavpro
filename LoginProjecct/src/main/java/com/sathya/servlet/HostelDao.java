package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HostelDao
{
	public int save(Hostel hostel)
	{
		int count=0;
		//Connection connection=null;
		PreparedStatement preparedstatement =null;
		try
		{
			Connection connection=HostelDbconnection.createConnection();
			preparedstatement=connection.prepareStatement("insert into hostel_datails values(?,?,?,?,?,?)");
			
			preparedstatement.setString(1, hostel.getName());
			preparedstatement.setString(2, hostel.getUsername());
			preparedstatement.setString(3, hostel.getPassword());
			preparedstatement.setString(4, hostel.getEmail());
			preparedstatement.setLong(5, hostel.getMobile());
			preparedstatement.setString(6, hostel.getAddress());
			
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
		}
	
	public List<Hostel> getUserName(String username) {
        PreparedStatement preparedstatement = null;
        List<Hostel> hostel = new ArrayList<>();
        try {
            Connection connection = HostelDbconnection.createConnection();
            preparedstatement = connection.prepareStatement("select username, password from hostel_datails where username=?");
            preparedstatement.setString(1, username);
            ResultSet resultSet = preparedstatement.executeQuery();
            if (resultSet.next()) {
                Hostel hoste = new Hostel();
                hoste.setUsername(resultSet.getString(1));
                hoste.setPassword(resultSet.getString(2));
                hostel.add(hoste);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostel;
    }
	
	
	public String getEmail(String username)
	
	{
		PreparedStatement preparedstatement =null;
		String email=null;
		try
		{
			//System.out.println("U: "+username);
			Connection connection=HostelDbconnection.createConnection();
			preparedstatement=connection.prepareStatement("select email from hostel_datails where username=?");
			
			preparedstatement.setString(1,username);
			ResultSet resultSet=preparedstatement.executeQuery();
			if(resultSet.next())
			{
				email=(resultSet.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return email;
	}	
	
}
