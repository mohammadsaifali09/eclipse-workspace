package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class BatchWithStatement
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Saif@@09");
			statement=connection.createStatement();
			statement.addBatch("delete from user where phone=999");
			statement.addBatch("update user set name='XYZ',phone=777 where id=2");
			statement.addBatch("insert into user values(5,'Pushpa',9999)");
			int[] r=statement.executeBatch();
			for (int i = 0; i < r.length; i++)
			{
				System.out.println(r[i]+" rows are affected");
			}
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
