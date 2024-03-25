package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//step-1
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		//step-2
		int result=0;
		switch(operation)
		{
		case "+" : result=num1+num2;
					break;
					
		case "-" : result=num1-num2;
					break;
		
		case "*" : result=num1*num2;
					break;
		
		case "/" : result=num1/num2;
					break;
		
		case "%" : result=num1%num2;
					break;
		}
		
		//step-3
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor="+"pink"+">");
		writer.println("Enter the FirstNumber :"+num1+"<br>");
		writer.println("Enter the SecondNumber:   "+num2+"<br>");
		writer.println("Enter the operation:  "+operation+"<br>");
		writer.println("Result:  "+result);
		writer.println("</body>");
		writer.println("</html>");	
	
	}
}
