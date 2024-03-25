package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/siva")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Welcome to Sathya Technologies</h1>");
		writer.println("<h3>Welcome to Servlet Application</h3>");
		writer.println("<h5>Welcome to Mr.Ratan classes</h5>");
		writer.println("</html>");

	}

}
