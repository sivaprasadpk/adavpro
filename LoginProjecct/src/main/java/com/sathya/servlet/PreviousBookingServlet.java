package com.sathya.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreviousBookingServlet
 */
@WebServlet("/PreviousBookingServlet")
public class PreviousBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviousBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDetailsDao dao = new BookDetailsDao();
		List<BookingDetails> book =dao.getPreviousDetails();
		
		for(BookingDetails details:book)
		System.out.println(details.getUsername()+" "+details.getRoomType()+" "+details.getCheckInDate()+" "+details.getCheckOutDate()+" "+details.getDuration()+" "+details.getRent());
		
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookDetails.jsp");
		dispatcher.forward(request, response);
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
