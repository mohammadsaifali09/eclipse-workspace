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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		PrintWriter writer=response.getWriter();
		writer.write("<html><body><h1>You are logged Out</h1></body></html>");
		RequestDispatcher dispatcher=null;
		dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.include(request, response);
	}
}
