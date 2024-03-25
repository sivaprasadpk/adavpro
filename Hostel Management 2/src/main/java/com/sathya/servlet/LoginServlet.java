package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao dao = new UserDao();
		int res = dao.findDetails(username, password);
		int luxuryRooms = new HostelDAO().getAvailableRooms("Luxury");
		int deluxeRooms = new HostelDAO().getAvailableRooms("Deluxe");
		int normalRooms = new HostelDAO().getAvailableRooms("Normal");
		if (res == 1) {
			request.setAttribute("deluxeRooms", deluxeRooms);
			request.setAttribute("luxuryRooms", luxuryRooms);
			request.setAttribute("normalRooms", normalRooms);
			request.setAttribute("username", username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			request.setAttribute("result", res);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}

	}

}
