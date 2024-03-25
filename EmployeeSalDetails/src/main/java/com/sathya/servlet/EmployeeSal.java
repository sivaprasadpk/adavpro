package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeSal")

public class EmployeeSal extends HttpServlet
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			int Id=Integer.parseInt(request.getParameter("EmpId"));
			String Name=request.getParameter("EmpName");
			double Salary=Double.parseDouble(request.getParameter("EmpSalary"));
			
			double hra,pf,da,grosssalary;
			
			if (Salary<25000)
			{
				da=Salary*3/100;
				hra=Salary*10/100;
				pf=Salary*2/100;
			}
			else if (Salary<=25000 && Salary<50000 )
			{
				da=Salary*5/100;
				hra=Salary*20/100;
				pf=Salary*3/100;
			}
			else
			{
				da=Salary*10/100;
				hra=Salary*30/100;
				pf=Salary*6/100;
			}
			grosssalary=hra+pf+da;
			
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<body bgcolor="+"pink"+">");
			writer.println("EmployeeId:   "+Id+"<br>");
			writer.println("EmployeeName:   "+Name+"<br>");
			writer.println("EmployeeSalary:  $"+Salary+"<br>");
			writer.println("Employee Hra: $"+hra+"<br>");
			writer.println("Employee Da:  $"+da+"<br>");
			writer.println("Employee Pf:  $"+pf+"<br>");
			writer.println("GrossSalary:  $"+grosssalary);
			writer.println("</html>");	
		}

}
