package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HostelDAO {

	// this method enters the details of the Resident

	public int saveResidentDetails(Hostel hostel) {
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into Resident_details values(?,?,?,?,?,?)");) {
			preparedStatement.setString(1, hostel.getFullName());
			preparedStatement.setString(2, hostel.getUserName());
			preparedStatement.setString(3, hostel.getUserPassword());
			preparedStatement.setString(4, hostel.getUserMobile());
			preparedStatement.setString(5, hostel.getUserEmail());
			preparedStatement.setString(6, hostel.getAddress());

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection failed");
		}
		return count;
	}

	public List<Hostel> findAll() {
		List<Hostel> hostel = new ArrayList<Hostel>();

		try (Connection connection = Dbconnection.createConnection();) {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("Select * from Hostel_details");

			while (resultSet.next()) {
				Hostel hostel1 = new Hostel();

				hostel1.setCategory(resultSet.getString(1));
				hostel1.setRooms_Available(resultSet.getInt(2));
				hostel.add(hostel1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hostel;

	}

	public Hostel findByuserName(String UserName) {
		Hostel hostel = null;

		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from Resident_details where UserName = ?");) {
			preparedStatement.setString(1, UserName);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				hostel = new Hostel();

				hostel.setUserName(resultSet.getString(2));
				hostel.setUserPassword(resultSet.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return hostel;
	}

	public int UpdateAvailability(String Category) {
		int count = 0;

		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update Resident_Booking_details set Rooms_Available = Rooms_Available-1 where Category = ? )");) {

			preparedStatement.setString(1, Category);

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection failed");
		}
		return count;
	}

	public int getAvailableRooms(String type) {
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select rooms_available from hostel_details where Category = ?");) {

			preparedStatement.setString(1, type);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection failed");
		}

		return count;
	}

	public int saveBookingDetails(BookingDetails details) {
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into booking_details(username,roomtype, checkindate, checkoutdate, duration, rent, aadhaarfront, aadhaarback) values(?,?,?,?,?,?,?,?)");) {
			preparedStatement.setString(1, details.getUserName());
			preparedStatement.setString(2, details.getRoomType());
			preparedStatement.setDate(3, details.getCheckInDate());
			preparedStatement.setDate(4, details.getCheckOutDate());
			preparedStatement.setInt(5, details.getDuration());
			preparedStatement.setDouble(6, details.getRent());
			preparedStatement.setBytes(7, details.getAadhaarFront());
			preparedStatement.setBytes(8, details.getAadhaarBack());

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection failed");
		}
		return count;
	}
	
	public List<BookingDetails> previousBookingDetails(String username) {
		List<BookingDetails> previousBookings = new ArrayList<BookingDetails>();
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select bookingid, roomtype, checkindate, checkoutdate, duration, rent from booking_details where username=?" );) {
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				BookingDetails details = new BookingDetails();
				details.setBookingId(resultSet.getString(1));
				details.setRoomType(resultSet.getString(2));
				details.setCheckInDate(resultSet.getDate(3));
				details.setCheckOutDate(resultSet.getDate(4));
				details.setDuration(resultSet.getInt(5));
				details.setRent(resultSet.getDouble(6));
				previousBookings.add(details);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection failed");
		}
		return previousBookings;
	}
}
