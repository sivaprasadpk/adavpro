package Com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username=request.getParameter("UserName");
		String password=request.getParameter("Password");
		
		String status;
		if(username.equals("siva")&&password.equals("siva@10"))
			status="Login SuccesFul....";
		else
			status="Login Fail....";
		
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Login Status......</h1>"+status);
		writer.println("</html>");
	}


}
