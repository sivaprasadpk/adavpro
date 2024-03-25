package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		     String username = request.getParameter("UserName");
	        String password = request.getParameter("Password");
	        HostelDao dao = new HostelDao();
	        List<Hostel> hostel = dao.getUserName(username);

	        if (!hostel.isEmpty()) {
	            Hostel user = hostel.get(0);
	            if (user.getPassword().equals(password)) {
	                RequestDispatcher dispatcher = request.getRequestDispatcher("Home1.html");
	                dispatcher.forward(request, response);
	            } else {
	                response.setContentType("text/html");
	                PrintWriter writer = response.getWriter();
	                writer.println("<h5>Login failed, please check your credentials.</h5>");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
	                dispatcher.include(request, response);
	            }
	        } else {
	            response.setContentType("text/html");
	            PrintWriter writer = response.getWriter();
	            writer.println("<h5>Username does not exist.</h5>");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
	            dispatcher.include(request, response);
	        }
       
    }
}

	
