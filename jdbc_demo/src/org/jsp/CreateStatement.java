package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306";
		user="root";
		password="Saif@@09";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			statement=connection.createStatement();
			System.out.println("Platform Created");
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
		}
	}
}
