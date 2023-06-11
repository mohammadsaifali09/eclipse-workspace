package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMultipleRecordsUsingPreparedStatement
{
	public static void main(String[] args)
	{
		Connection connection=null;
		PreparedStatement pStatement=null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="Saif@@09";
		String query="insert into user values(?,?,?)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			pStatement=connection.prepareStatement(query);
			System.out.println("Platform Created");
			pStatement.setInt(1, 5);
			pStatement.setString(2, "A");
			pStatement.setInt(3, 88888);
			pStatement.executeUpdate();
			
			pStatement.setInt(1, 6);
			pStatement.setString(2, "B");
			pStatement.setInt(3, 99999);
			pStatement.executeUpdate();
			
			pStatement.setInt(1, 7);
			pStatement.setString(2, "C");
			pStatement.setInt(3, 876489);
			pStatement.executeUpdate();
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
			if (pStatement !=null)
			{
				try
				{
					pStatement.close();
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
