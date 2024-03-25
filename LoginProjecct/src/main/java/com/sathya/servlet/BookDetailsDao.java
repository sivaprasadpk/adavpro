package com.sathya.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailsDao 
{
	public int save(BookingDetails details)
	{
	int count=0;
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	try
	{
		
		connection=HostelDbconnection.createConnection();
		preparedStatement=connection.prepareStatement("insert into booking_details values(?,?,?,?,?,?,?)");
		preparedStatement.setString(1,details.getUsername());
		preparedStatement.setString(2,details.getRoomType());
		preparedStatement.setDate(3, details.getCheckInDate());
		preparedStatement.setDate(4, details.getCheckOutDate());
		preparedStatement.setInt(5, details.getDuration());
		preparedStatement.setDouble(6, details.getRent());
		preparedStatement.setBytes(7, details.getAaadhar());
		
		count=preparedStatement.executeUpdate();
		
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return count;
	}
	public int avaliableRooms(String roomType)
	{
		System.out.println("RT: "+roomType);
		int count=0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{
			connection=HostelDbconnection.createConnection();
			preparedStatement=
					connection.prepareStatement("select rooms_available from hostel_details where category=?");
			preparedStatement.setString(1, roomType);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				count=resultSet.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		return count;
	
	}
	public  String roomType(int avaliableRooms)
	{
		String s=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{
			connection=HostelDbconnection.createConnection();
			preparedStatement=
					connection.prepareStatement("select category from hostel_details where rooms_available=?");
			preparedStatement.setInt(1,avaliableRooms);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				s=resultSet.getString(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public int updateRooms(String roomType) {
	    int count = 0;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try 
	    
	    {
	        connection = HostelDbconnection.createConnection();
	        preparedStatement = connection.prepareStatement("UPDATE hostel_details SET rooms_available = rooms_available - 1 WHERE category = ?");
	        preparedStatement.setString(1, roomType);
	        count = preparedStatement.executeUpdate();
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    } 
	    return count;
	}
	public List<BookingDetails> getPreviousDetails()
	{
		List <BookingDetails> details=new ArrayList();
		Connection connection=null;
		PreparedStatement  preparedStatement=null;
		 try 
		    
		    {
		        connection = HostelDbconnection.createConnection();
		        preparedStatement = connection.prepareStatement("select * from booking_details");
		        
		        ResultSet resultSet=preparedStatement.executeQuery();
		        BookingDetails bookingDetails=new BookingDetails();
		        while(resultSet.next())
		        {
		        	bookingDetails.setUsername(resultSet.getString(1));
		        	bookingDetails.setRoomType(resultSet.getString(2));
		        	bookingDetails.setCheckInDate(resultSet.getDate(3));
		        	bookingDetails.setCheckOutDate(resultSet.getDate(4));
		        	bookingDetails.setDuration(resultSet.getInt(5));
		        	bookingDetails.setRent(resultSet.getDouble(6));
		        	bookingDetails.setAaadhar(resultSet.getBytes(7));
		        	details.add(bookingDetails);
		        	
		        }
		     
		    }
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return details;		
	}

}
	