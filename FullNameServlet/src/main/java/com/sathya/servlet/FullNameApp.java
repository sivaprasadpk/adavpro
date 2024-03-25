package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FullNameApp")
public class FullNameApp extends HttpServlet
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String firstname=request.getParameter("FirstName");
			String middlename=request.getParameter("MiddleName");
			String lastname=request.getParameter("LastName");
			
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			writer.println("<html>");
			writer.println("<h1>your full name is :</h1>"+firstname+" "+middlename+" "+lastname);
			writer.println("</html>");
			
		}

}
