package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet
{
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			//step-1 get the client data
			String email=request.getParameter("E-mail");
			String mobile=request.getParameter("Mobile");
			
			//step-2 create a session object
			HttpSession httpSession=request.getSession(false);
			
			//step-3 display all data
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			writer.println("<html>");
			writer.println("<body bgcolor='red'>");
			writer.println("<pre>");
			writer.println("Username..."+httpSession.getAttribute("UserName"));
			writer.println("Age..."+httpSession.getAttribute("Age"));
			writer.println("Qualification..."+httpSession.getAttribute("Qualification"));
			writer.println("Designation..."+httpSession.getAttribute("Designation"));
			writer.println("E-mail..."+email);
			writer.println("Mobile..."+mobile);
			writer.println("</pre>");
			writer.println("</body>");
			writer.println("</html>");

			
		}

}
