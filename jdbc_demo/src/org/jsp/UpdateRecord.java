package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRecord
{
	public static void main(String[] args)
	{
		Connection connection=null;
		PreparedStatement pst=null;
		String qry="Update user set name=?,phone=? where id=?";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Existing ID");
		int id=scanner.nextInt();
		System.out.println("Enter the name and phone Number to Update");
		String name=scanner.next();
		Long phone=scanner.nextLong();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Saif@@09");
			pst=connection.prepareStatement(qry);
			pst.setInt(3, id);
			pst.setString(1, name);
			pst.setLong(2, phone);
			pst.executeUpdate();
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
			if (pst !=null)
			{
				try
				{
					pst.close();
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
