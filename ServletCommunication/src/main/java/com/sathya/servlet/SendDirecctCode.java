package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SendDirecctCode")
public class SendDirecctCode extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String username=request.getParameter("UserName");
			String password=request.getParameter("Password");
			
			if(username.equals("siva")&&password.equals("siva@10"))
			{
				response.sendRedirect("http://www.tcs.com");
			}
			else
			{
				response.sendError(808,"login fail please check the username");
				
			}
	
		}

	
}
