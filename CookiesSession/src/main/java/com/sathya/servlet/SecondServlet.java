package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet
{
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			//step-1 get the client data
			String qual=request.getParameter("Qualification");
			String des=request.getParameter("Designation");
			
			//step-2 create a cookie object
			Cookie cookie1=new Cookie("Qualification", qual);
			Cookie cookie2=new Cookie("Designation", des);
			
			//step-3 reading all cookies
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		
			//step-4 create a requested dispatcher
			RequestDispatcher dispatcher=request.getRequestDispatcher("Form3.html");
			dispatcher.forward(request, response);

		}

}
