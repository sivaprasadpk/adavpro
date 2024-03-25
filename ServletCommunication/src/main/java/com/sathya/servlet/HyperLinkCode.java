package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HyperLinkCode")
public class HyperLinkCode extends HttpServlet 
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String username=request.getParameter("UserName");
			String password=request.getParameter("Password");
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			if(username.equals("siva")&&password.equals("siva@10"))
			{
				
				writer.println("login successfulll....");
				writer.println("<a href ='http://www.sachintendulkar images'>cilck to here to open </a>");
			}
			else
			{
				writer.println("login fail");
				writer.println("<a href='login3.html'>cilck to here to open </a>");
			}
			
		}

	
}
