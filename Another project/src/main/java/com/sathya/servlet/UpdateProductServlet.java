package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    	{
			String proId=request.getParameter("proId");
			String proName=request.getParameter("proName");
			double proPrice=Double.parseDouble(request.getParameter("proPrice"));
			String proBrand=request.getParameter("proBrand");
			String proMadein=request.getParameter("proMadein");
			Date MfgDate=Date.valueOf(request.getParameter("MfgDate"));
			Date Expiry=Date.valueOf(request.getParameter("Expiry"));
			Product product=new Product();
	        product.setProId(proId);
	        product.setProName(proName);
	        product.setProPrice(proPrice);
	        product.setProBrand(proBrand);
	        product.setProMadein(proMadein);
	        product.setProMfgDate(MfgDate);
	        product.setProExpDate(Expiry);

	        Part part = request.getPart("proImage");
	        if (part.getSize() > 0) {
	            InputStream inputStream = part.getInputStream();
	            byte[] proImage = IOUtils.toByteArray(inputStream);
	            product.setProImage(proImage);
	        } else {
	            String p = request.getParameter("existingImage");
	            byte[] proImage = Base64.getDecoder().decode(p);
	            product.setProImage(proImage);
	        }

	        Part part1 = request.getPart("newproAudio");
	        if (part1.getSize() > 0) {
	            InputStream inputStream1 = part1.getInputStream();
	            byte[] newproAudio = IOUtils.toByteArray(inputStream1);
	            product.setProAudio(newproAudio);
	        } 
	        else
	        {
	            String p1 = request.getParameter("existingAudio");
	            byte[] oldproAudio = Base64.getDecoder().decode(p1);
	            product.setProAudio(oldproAudio);
	        }
	        
	        Part part2 = request.getPart("newproVideo");
	        if (part2.getSize() > 0) {
	            InputStream inputStream2 = part2.getInputStream();
	            byte[] newproVideo = IOUtils.toByteArray(inputStream2);
	            product.setProVideo(newproVideo);
	        } 
	        else
	        {
	            String p2 = request.getParameter("existingVideo");
	            byte[] oldproAudio = Base64.getDecoder().decode(p2);
	            product.setProVideo(oldproAudio);
	        }

	        ProductDao dao = new ProductDao();
	        int result = dao.update(product);

	        if (result == 1) 
	        {
	        	request.setAttribute("result",result);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            response.setContentType("text/html");
	            PrintWriter writer = response.getWriter();
	            writer.println("Data update failed. Check once... Result: " + result);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("Add-Product.html");
	            dispatcher.include(request, response);
	        }
	    }

}

