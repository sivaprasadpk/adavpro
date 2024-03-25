package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//step-1 get the client data
		String email=request.getParameter("E-mail");
		String mobile=request.getParameter("Mobile");
		
		Cookie[] cookie=request.getCookies();
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor='orange'>");
		writer.println("<pre>");
		writer.println("Username..."+cookie[0].getValue());
		writer.println("Age..."+cookie[1].getValue());
		writer.println("Qualification..."+cookie[2].getValue());
		writer.println("Designation..."+cookie[3].getValue());
		writer.println("E-mail..."+email);
		writer.println("Mobile..."+mobile);
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");

	}

}
