package org.jsp.userapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch")
public class FetchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String qry="select * from user where id=?";
		try
		{
			Class.forName(UserUtility.DRIVER);
			con=DriverManager.getConnection(UserUtility.URL,UserUtility.USER,UserUtility.PASSWORD);
			pst=con.prepareStatement(qry);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			PrintWriter writer=response.getWriter();
			if (rs.next())
			{
				writer.write("<html><body><h1>ID: "+rs.getInt(1)+"</h1>");
				writer.write("<h1>Name: "+rs.getString("name")+"</h1>");
				writer.write("<h1>Age: "+rs.getInt("age")+"</h1>");
				writer.write("<h1>Phone Number: "+rs.getLong("phone")+"</h1></body></html>");
			}
			else
			{
				writer.write("<html><body><h1>Entered Id is Invalid</h1></body></html>");
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
