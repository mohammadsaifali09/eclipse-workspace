package org.jsp.servletdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet{
static {
	System.out.println("Test class loaded into JVM  Memory");
}
public Test() {
	System.out.println("Test object getting created");
}
@Override
	public void init() throws ServletException {
		System.out.println("The members are getting initialized");
	}
@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("This is your service method");
	}
@Override
	public void destroy() {
		System.out.println("Test object is destroyed");
	}
}
