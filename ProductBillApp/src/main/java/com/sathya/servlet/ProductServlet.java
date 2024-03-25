package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
	  //step 1:get the requested data
		int proId=Integer.parseInt(request.getParameter("proId"));
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		
	 //step 2:process the data
		
		double totalbill=proPrice*proQuantity;
		double discount=0.00,dis=0.00;
		String s;
		if(totalbill<1000)
		{
			dis=0.00;
			discount=totalbill;
		}
		else if(totalbill>1000 && totalbill<5000)
		{
			dis=totalbill*5/100;
			discount=totalbill-dis;
		}
		else if(totalbill>5000 && totalbill<10000)
		{
			dis=totalbill*10/100;
			discount=totalbill-dis;
		}
		else
		{
			dis=totalbill*15/100;
			discount=totalbill-dis;
		}
	//step 3:render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor="+"pink"+">");
		writer.println("productId:   "+proId+"<br>");
		writer.println("productName:   "+proName+"<br>");
		writer.println("productprice:    $"+proPrice+"<br>");
		writer.println("productQuantity:   "+proQuantity+"<br>");
		writer.println("TotalBill:  $"+totalbill+"<br>");
		writer.println("Discount:   $"+dis+"<br>");
		writer.println("total net pay amunt: $"+discount);
		writer.println("</html>");
			
	}

}
	