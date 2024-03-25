package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GenerateNumberServlet")
public class GenerateNumberServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		List<Integer> l=new ArrayList<Integer>();
		if(operation.equals("Even"))
		{
			for(int i=num1;i<=num2;i++)
				if(i%2==0)
					l.add(i);
		}
		else if(operation.equals("Odd"))
		{
			for(int i=num1;i<=num2;i++)
				if(i%2==1)
					l.add(i);
		}
		else if(operation.equals("Prime"))
		{
			int f=0;
			for(int i=num1;i<=num2;i++)
			{
				 f=0;
				for(int j=2;j<=i/2;j++)
				{
					if(i%j==0)
					{
						f=1;
						break;
					}
				}
				if(f==0 && i!=1)
					
					l.add(i);
					
			}
		}
		else if(operation.equals("Perfect"))
		{
			int sum=0;
			for(int i=num1;i<=num2;i++)
			{
				sum=0;
				for(int j=1;j<i;j++)
				{
					if(i%j==0)
						sum+=j;
				}
				if(sum==i)
					l.add(i);
			}
		}
		else if(operation.equals("Strong"))
		{
			int i;
			for( i=num1;i<=num2;i++)
			{
				int temp=i,rem=0,fact=1,sum=0;
				while(temp>0)
				{
					rem=temp%10;
						fact=1;
					for(int j=1;j<=rem;j++)
						fact=fact*j;
					
					sum=sum+fact;
					temp=temp/10;
				}
				if(i==sum)
					l.add(i);
			}
		}
		
		else if(operation.equals("Armstrong"))
		{
			for(int i=num1;i<=num2;i++)
			{
				int temp=i,count=0,rem=0;
				double sum=0;
				while(temp>0)
				{
					count++;
					temp=temp/10;
				}
				int temp1=i;
				while(temp1>0)
				{
					rem=temp1%10;
					sum=sum+Math.pow(rem, count);
					temp1=temp1/10;
				}
				if(sum==i)
					l.add(i);
			}
		}
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor="+"pink"+">");
		writer.println("Enter the FirstNumber :"+num1+"<br>");
		writer.println("Enter the SecondNumber:   "+num2+"<br>");
		writer.println("Enter the operation:  "+operation+"<br>");
		writer.println("Result:  "+l);
		writer.println("</body>");
		writer.println("</html>");	

		
		
	}
		
}
