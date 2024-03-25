package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			//step-1 get the client data
			String username=request.getParameter("UserName");
			String age=request.getParameter("Age");
			
			//step-2 create a session object
			HttpSession httpSession=request.getSession();
			
			//step-3 place a requested data in session object
			httpSession.setAttribute("UserName", username);
			httpSession.setAttribute("Age", age);
			
			//step-4 create a requested dispatcher
			RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
			dispatcher.forward(request, response);
		}

}
