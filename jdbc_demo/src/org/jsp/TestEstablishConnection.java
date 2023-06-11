package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestEstablishConnection
{

	public static void main(String[] args)
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is Loaded and Registered");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Saif@@09");
			System.out.println("Connection has been established");
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
					System.out.println("Connection is closed ");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

}
