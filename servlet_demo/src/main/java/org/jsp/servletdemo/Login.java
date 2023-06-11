package org.jsp.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long phone=Long.parseLong(request.getParameter("ph"));
		String password=request.getParameter("ps");
		PrintWriter writer=response.getWriter();
		RequestDispatcher dispatcher=null;
		if (phone==888777 && password.equals("a123"))
		{
			dispatcher=request.getRequestDispatcher("home1.html");
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("login1.html");
			writer.write("<html><body><h2>Invalid Phone number or password</h2></body></html>");
			dispatcher.include(request, response);
		}
	}

}
