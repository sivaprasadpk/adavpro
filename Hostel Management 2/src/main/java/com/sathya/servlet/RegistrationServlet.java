package com.sathya.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");

        out.println("<html><body><title>Hostel Registration Details</title>");
        out.println("<h2>Hostel Registration Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Mobile: " + mobile + "</p>");
        out.println("<p>Address: " + address + "</p>");
        out.println("</body></html>");
    }
}

