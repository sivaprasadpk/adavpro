package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("Name");
		String username=request.getParameter("UserName");
		String password=request.getParameter("Password");
		String cpassword=request.getParameter("confrim");
		String email=request.getParameter("email");
		long mobile=Long.parseLong(request.getParameter("Mobile"));
		String address=request.getParameter("address");
		
		Hostel hostel=new Hostel();
		hostel.setName(name);
		hostel.setUsername(username);
		hostel.setPassword(password);
		hostel.setCpassword(cpassword);
		hostel.setEmail(email);
		hostel.setMobile(mobile);
		hostel.setAddress(address);
				
		HostelDao dao=new HostelDao();
		int res=dao.save(hostel);
		
		if(res==1)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.html");
			dispatcher.forward(request, response);
		}
		
	}

}
