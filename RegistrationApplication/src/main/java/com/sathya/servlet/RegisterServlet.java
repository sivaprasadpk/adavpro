package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		//step-1 read the data from requested form
			String username=request.getParameter("UserName");
			String password=request.getParameter("Password");
			long mobile=Long.parseLong(request.getParameter("mobile"));
			String email=request.getParameter("email");
			
			String gender=request.getParameter("gender");
			String dob=request.getParameter("dob");	
			String[] quals=request.getParameterValues("qualification");
			String country=request.getParameter("country");
			String[] lan=request.getParameterValues("language");
			String comments=request.getParameter("comments");
			
			
			//step-2 process it
			
			String q=String.join("," ,quals);
			String l=String.join("-", lan);
			
			//step-3 response to client
			
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<body bgcolor="+"pink"+">");
			writer.println("Your Name:  "+username+"<br>");
			writer.println("Your Password:  "+password+"<br>");
			writer.println("Your Email:    "+email+"<br>");
			writer.println("Your MobileNumber:   "+mobile+"<br>");
			writer.println("Gender:  "+gender+"<br>");
			writer.println("DOB:   "+dob+"<br>");
			writer.println("Qualification:   "+q+"<br>");
			writer.println("Country:   "+country+"<br>");
			writer.println("Languages: "+l+"<br>");
			writer.println("Comments:   "+comments+"<br>");
			writer.println("</html>");

			
			
			
		}

	
}
