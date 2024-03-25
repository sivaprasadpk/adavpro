package com.sathya.servlet;

import java.sql.Date;

public class BookingDetails 
{
	String Username;
	String RoomType;
	Date CheckInDate;
	Date CheckOutDate;
	int Duration;
	Double Rent;
	byte[] Aaadhar;
	
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public Date getCheckInDate() {
		return CheckInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		CheckInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return CheckOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		CheckOutDate = checkOutDate;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public Double getRent() {
		return Rent;
	}
	public void setRent(Double rent) {
		Rent = rent;
	}
	public byte[] getAaadhar() {
		return Aaadhar;
	}
	public void setAaadhar(byte[] aaadhar) {
		Aaadhar = aaadhar;
	}
	
	
	
}
