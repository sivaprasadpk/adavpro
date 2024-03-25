package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RequestDispactcherInclude")
public class RequestDispactcherInclude extends HttpServlet
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String username=request.getParameter("UserName");
			String password=request.getParameter("Password");
			
			if(username.equals("siva")&&password.equals("siva@10"))
			{
				RequestDispatcher dispatcher= request.getRequestDispatcher("success.html");
						dispatcher.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter printWriter=response.getWriter();
				printWriter.println("login fail cheeck credentails once");
				RequestDispatcher dispatcher= request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
	
			}
				
		}	
}
