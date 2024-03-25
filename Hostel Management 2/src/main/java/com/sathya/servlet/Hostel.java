package com.sathya.servlet;

import java.sql.Date;

public class Hostel {
	private String UserName;
	private String UserPassword;
	private String UserMobile;
	private String UserEmail;
	private String Address;
	private String FullName;
	private String Category;
	private int Rooms_Available;
	private Date Check_in_date;
	private Date Check_out_date;
	private String duration;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getCheck_in_date() {
		return Check_in_date;
	}

	public void setCheck_in_date(Date check_in_date) {
		Check_in_date = check_in_date;
	}

	public Date getCheck_out_date() {
		return Check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		Check_out_date = check_out_date;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getRooms_Available() {
		return Rooms_Available;
	}

	public void setRooms_Available(int rooms_Available) {
		Rooms_Available = rooms_Available;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserMobile() {
		return UserMobile;
	}

	public void setUserMobile(String userMobile) {
		UserMobile = userMobile;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

}
