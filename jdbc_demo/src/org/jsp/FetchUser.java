package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchUser
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Saif@@09");
			statement=connection.createStatement();
			
//			By using executeQuery() method
			rs=statement.executeQuery("select * from user where id=2");
			while (rs.next())
			{
				System.out.println(rs.getInt("id")+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
//			By using execute() method
//			boolean result=statement.execute("select * from user where id=3");
//			if (result==true)
//			{
//				statement.getResultSet();
//			}
//			while (rs.next())
//			{
//				System.out.println(rs.getInt("id")+" "+rs.getString(2)+" "+rs.getString(3));
//			}
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection !=null)
			{
				try
				{
					connection.close();
					System.out.println("Connection closed");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (statement !=null)
			{
				try
				{
					statement.close();
					System.out.println("Statement closed");
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
					System.out.println("ResultSet closed");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
