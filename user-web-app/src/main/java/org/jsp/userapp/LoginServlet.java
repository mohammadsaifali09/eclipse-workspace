package org.jsp.userapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
     
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long phone=Long.parseLong(request.getParameter("ph"));
		String password=request.getParameter("ps");
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String qry="select * from user where phone=? and password=?";
		try
		{
			Class.forName(UserUtility.DRIVER);
			con=DriverManager.getConnection(UserUtility.URL,UserUtility.USER,UserUtility.PASSWORD);
			pst=con.prepareStatement(qry);
			pst.setLong(1, phone);
			pst.setString(2, password);
			rs=pst.executeQuery();
			RequestDispatcher dispatcher=null;
			if(rs.next())
			{
				dispatcher=request.getRequestDispatcher("home.jsp");
				HttpSession session=request.getSession();
				session.setAttribute("id", rs.getInt("id"));
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("age", rs.getInt("age"));
				session.setAttribute("phone", rs.getLong("phone"));
				session.setAttribute("password", rs.getString(5));
				dispatcher.forward(request, response);
			}
			else
			{
				PrintWriter writer=response.getWriter();
				writer.write("<html><body><h1>Invalid phone or password</h1></body></html>");
				dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.include(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con !=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (pst !=null)
			{
				try
				{
					pst.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (rs !=null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
