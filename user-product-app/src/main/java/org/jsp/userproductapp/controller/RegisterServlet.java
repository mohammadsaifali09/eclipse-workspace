package org.jsp.userproductapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.userproductapp.dao.UserDao;
import org.jsp.userproductapp.dto.User;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		String email = req.getParameter("em");
		String password = req.getParameter("ps");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("ph"));
		User u = new User(name, gender, password, email, phone, age);
		UserDao dao = new UserDao();
		u = dao.saveUser(u);
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h2>User registered with id: " + u.getId() + "</h2></body></html>");
	}
}
