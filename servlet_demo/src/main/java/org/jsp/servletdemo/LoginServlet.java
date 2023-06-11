package org.jsp.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("mail");
		String password=req.getParameter("pass");
		PrintWriter writer=resp.getWriter();
		if (email.equals("mohammadsaifali09@gmail.com") && password.equals("saif1234"))
		{
			writer.write("<html><body><h2>Login Succesfull</h2></body></html>");
		}
		else
		{
			writer.write("<html><body><h2>Invalid email or password</h2></body></html>");
		}
	}
}
