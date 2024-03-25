package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreviousBookingServlet")
public class PreviousBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=(String)request.getParameter("username");
		List<BookingDetails> previousBookings = new HostelDAO().previousBookingDetails(username);
		request.setAttribute("previousBookings", previousBookings);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("previousBookings.jsp");
		dispatcher.forward(request, response);
	}

}
