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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=(String) request.getSession().getAttribute("name");
		Connection con=null;
		PreparedStatement pst=null;
		String qry="delete from user where id=?";
		if(name !=null)
		{
			try
			{
				Class.forName(UserUtility.DRIVER);
				con=DriverManager.getConnection(UserUtility.URL,UserUtility.USER,UserUtility.PASSWORD);
				pst=con.prepareStatement(qry);
				pst.setLong(1, id);
				pst.executeUpdate();
				PrintWriter writer=response.getWriter();
				writer.write("<html><body><h1>User details Deleted Succesfully</h1></body></html>");
				request.getSession().invalidate();
				RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.include(request, response);
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
		else
		{
			response.sendRedirect("login.jsp");
		}
	}
}
