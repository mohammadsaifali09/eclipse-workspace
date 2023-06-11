package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecords 
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="Saif@@09";
		String query1="insert into user values(2,'ABC',999)";
		String query2="insert into user values(3,'XYZ',999)";
		String query3="insert into user values(4,'PQR',999)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			statement=connection.createStatement();
			System.out.println("Platform Created");
			statement.executeUpdate(query1);
			statement.executeUpdate(query2);
			statement.executeUpdate(query3);
			System.out.println("Records Inserted Succesfully");
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
