package org.jsp.userapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long phone=Long.parseLong(request.getParameter("ph"));
		String password=request.getParameter("ps");
		RequestDispatcher dispatcher=null;
		PrintWriter writer=response.getWriter();
		if (phone==888488 && password.equals("s123"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("status", "succesfull");
			dispatcher=request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			writer.write("<html><body><h1>Invalid phone or password</h1></body></html>");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}
	}
}
