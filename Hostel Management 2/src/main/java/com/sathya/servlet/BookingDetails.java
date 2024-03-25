package com.sathya.servlet;

import java.sql.Date;

public class BookingDetails {
	private String bookingId;
	private String userName;
	private String roomType;
	private Date checkInDate;
	private Date checkOutDate;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public byte[] getAadhaarFront() {
		return aadhaarFront;
	}
	public void setAadhaarFront(byte[] aadhaarFront) {
		this.aadhaarFront = aadhaarFront;
	}
	public byte[] getAadhaarBack() {
		return aadhaarBack;
	}
	public void setAadhaarBack(byte[] aadhaarBack) {
		this.aadhaarBack = aadhaarBack;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	private int duration;
	private byte[] aadhaarFront;
	private byte[] aadhaarBack;
	private double rent;
	
}
