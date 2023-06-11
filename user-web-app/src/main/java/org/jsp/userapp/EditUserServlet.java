package org.jsp.userapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("nm");
		int age=Integer.parseInt(request.getParameter("age"));
		long phone=Long.parseLong(request.getParameter("ph"));
		String password=request.getParameter("ps");
		Connection con=null;
		PreparedStatement pst=null;
		String qry="update user set name=?,phone=?,age=?,password=? where id=?";
		try
		{
			Class.forName(UserUtility.DRIVER);
			con=DriverManager.getConnection(UserUtility.URL,UserUtility.USER,UserUtility.PASSWORD);
			pst=con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setLong(2, phone);
			pst.setInt(3, age);
			pst.setString(4, password);
			pst.setInt(5, id);
			pst.executeUpdate();
			PrintWriter writer=response.getWriter();
			writer.write("<html><body><h1>User details Updated Succesfully</h1></body></html>");
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
		}
	}

}
