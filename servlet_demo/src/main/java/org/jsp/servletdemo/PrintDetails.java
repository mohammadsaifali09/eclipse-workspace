package org.jsp.servletdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/print")
public class PrintDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("nm");
		Long phone=Long.parseLong(req.getParameter("ph"));
		String state=req.getParameter("st");
		String country=req.getParameter("ct");
		System.out.println("Your Details are printed below");
		System.out.println("Name: "+name);
		System.out.println("Phone: "+phone);
		System.out.println("State: "+state);
		System.out.println("Country: "+country);
		
	}
}
