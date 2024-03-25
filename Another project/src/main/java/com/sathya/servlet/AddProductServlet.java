package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//reading the data in form
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadein=request.getParameter("proMadein");
		Date MfgDate=Date.valueOf(request.getParameter("MfgDate"));
		Date Expiry=Date.valueOf(request.getParameter("Expiry"));
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		Part part2=request.getPart("proAudio");
		InputStream inputStream2=part2.getInputStream();
		Part part3=request.getPart("proVideo");
		InputStream inputStream3=part3.getInputStream();
		
		
		//conversion of inputstream to byte[]
		byte[] proImage = IOUtils.toByteArray(inputStream);
		byte[] proAudio=IOUtils.toByteArray(inputStream2);
		byte[] proVideo=IOUtils.toByteArray(inputStream3);
		
		//using above details create the product objects
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadein(proMadein);
		product.setProMfgDate(MfgDate);
		product.setProExpDate(Expiry);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
		//giving the product object to dao layer
		
		ProductDao dao=new ProductDao();
		int result=dao.save(product);
		
		if(result==1)
		{//to send the data to jsp file add the data into request data
			request.setAttribute("saveresult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("data insertion fail check once...."+result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Add-Product.html");
		dispatcher.include(request, response);
		}
		
		
	}

}
