package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="Saif@@09";
		String query="create table user (id int not null,name varchar(45) null,phone bigint(20) null,primary key(id))";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			statement=connection.createStatement();
			System.out.println("Platform Created");
			boolean res=statement.execute(query);
			System.out.println(res+" is the returned value and table is created");
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
