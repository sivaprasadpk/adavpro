package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//step-1 get the client data
		String qualification=request.getParameter("Qualification");
		String designation=request.getParameter("Designation");
		
		//step-2 create a session object
		HttpSession httpSession=request.getSession(false);
		
		//step-3 place a requested data in session object
		httpSession.setAttribute("Qualification", qualification);
		httpSession.setAttribute("Designation", designation);
		
		
		//step-4 create a requested dispatcher
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form3.html");
		dispatcher.forward(request, response);

	}

}
