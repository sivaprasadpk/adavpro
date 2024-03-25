package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/BookingServlet")
@MultipartConfig
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		LocalDate checkInDate = Date.valueOf(request.getParameter("checkIn")).toLocalDate();
		LocalDate checkOutDate = Date.valueOf(request.getParameter("checkOut")).toLocalDate();
		int duration = calculateDaysBetween(checkInDate, checkOutDate);

		Part part = request.getPart("adhaarFront");
		InputStream inputStream = part.getInputStream();
		byte[] aadhaarFront = IOUtils.toByteArray(inputStream);

		Part part1 = request.getPart("adhaarBack");
		InputStream inputStream1 = part1.getInputStream();
		byte[] aadhaarBack = IOUtils.toByteArray(inputStream1);

		int price1 = Integer.parseInt(request.getParameter("price1"));
		int price2 = Integer.parseInt(request.getParameter("price2"));
		int price3 = Integer.parseInt(request.getParameter("price3"));
		int price = 0;

		String email = new UserDao().getEmail(username);
		String type = request.getParameter("room");
		if (type.equalsIgnoreCase("luxury"))
			price = price1;
		else if (type.equalsIgnoreCase("deluxe"))
			price = price2;
		else
			price = price3;

		double totalRent = (double) duration * price;
		double sgst = totalRent * 0.09;
		double cgst = sgst;
		double discount = 0.05 * (totalRent + sgst + cgst);
		double totalPrice = totalRent + sgst + cgst - discount;

		BookingDetails details = new BookingDetails();
		details.setUserName(username);
		details.setRoomType(type);
		details.setCheckInDate(Date.valueOf(checkInDate));
		details.setCheckOutDate(Date.valueOf(checkOutDate));
		details.setDuration(duration);
		details.setRent(totalPrice);
		details.setAadhaarFront(aadhaarFront);
		details.setAadhaarBack(aadhaarBack);

		int result = new HostelDAO().saveBookingDetails(details);

		request.setAttribute("username", username);
		request.setAttribute("email", email);
		request.setAttribute("type", type);
		request.setAttribute("rentPerDay", price);
		request.setAttribute("checkInDate", checkInDate);
		request.setAttribute("checkOutDate", checkOutDate);
		request.setAttribute("duration", duration);
		request.setAttribute("totalRent", totalRent);
		request.setAttribute("cgst", cgst);
		request.setAttribute("sgst", sgst);
		request.setAttribute("discount", discount);
		request.setAttribute("totalPrice", totalPrice);

		RequestDispatcher dispatcher1 = request.getRequestDispatcher("BookingConfirmServlet");
		dispatcher1.forward(request, response);

	}

	public static int calculateDaysBetween(LocalDate date1, LocalDate date2) {
		// Calculate the difference using ChronoUnit
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		// Return the absolute value to ensure positive number of days
		return (int)Math.abs(daysBetween);
	}

}
