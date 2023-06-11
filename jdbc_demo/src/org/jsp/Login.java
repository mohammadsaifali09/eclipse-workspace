package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login
{
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your registered phone Number");
		Long phone=scanner.nextLong();
		System.out.println("Enter your password");
		String password=scanner.next();
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String qry="select * from person where phone=? and password=?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Saif@@09");
			pst=connection.prepareStatement(qry);
			pst.setLong(1, phone);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if (rs.next())
			{
				System.out.println("Login Succesfull");
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Phone: "+rs.getLong(4));
				System.out.println("Age: "+rs.getInt(3));
			}
			else
			{
				System.err.println("Invalid user and password");
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
			if (rs !=null)
			{
				try
				{
					rs.close();
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
