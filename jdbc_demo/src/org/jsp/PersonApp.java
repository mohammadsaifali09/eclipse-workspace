package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonApp
{
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter");
		System.out.println("1.To Save");
		System.out.println("2.To Update");
		System.out.println("3.To Delete By ID");
		System.out.println("4.To Fetch Person By ID");
		System.out.println("5.To Login");
		int choice=scanner.nextInt();
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Saif@@09");
			switch (choice)
			{
			    case 1:
			    {
			    	pst=connection.prepareStatement("insert into person values(?,?,?,?,?)");
			    	System.out.println("Enter your id,name,age,phone,password");
			    	int id=scanner.nextInt();
			    	String name=scanner.next();
			    	int age=scanner.nextInt();
			    	Long phone=scanner.nextLong();
			    	String password=scanner.next();
			    	pst.setInt(1, id);
			    	pst.setString(2, name);
			    	pst.setInt(3, age);
			    	pst.setLong(4, phone);
			    	pst.setString(5, password);
			    	pst.executeUpdate();
			    	System.out.println("Your Details are registered succesfully");
			    	break;
			    }
			    case 2:
			    {
			    	pst=connection.prepareStatement("update person set name=?,age=?,phone=?,password=? where id=?");
			    	System.out.println("Enter your Existing ID");
					int id=scanner.nextInt();
					System.out.println("Enter the name,age,phone_number and password to Update");
					String name=scanner.next();
					int age=scanner.nextInt();
					Long phone=scanner.nextLong();
					String password=scanner.next();
					pst.setInt(5, id);
			    	pst.setString(1, name);
			    	pst.setInt(2, age);
			    	pst.setLong(3, phone);
			    	pst.setString(4, password);
			    	pst.executeUpdate();
			    	System.out.println("Your Details are updated succesfully");
			    	break;
			    }
			    case 3:
			    {
			    	pst=connection.prepareStatement("delete from person where id=?");
			    	System.out.println("Enter your Existing ID To Delete");
			    	int id=scanner.nextInt();
			    	pst.setInt(1, id);
			    	pst.executeUpdate();
			    	System.out.println("Your Details are deleted succesfully");
			    }
			    case 4:
			    {
			    	pst=connection.prepareStatement("select * from person where id=?");
			    	System.out.println("Enter your Existing ID To Fetch");
			    	int id=scanner.nextInt();
					pst.setLong(1, id);
					rs=pst.executeQuery();
					while (rs.next())
					{
						System.out.println("ID: "+rs.getInt(1));
						System.out.println("Name: "+rs.getString(2));
						System.out.println("Age: "+rs.getInt(3));
						System.out.println("Phone: "+rs.getLong(4));
						System.out.println("Password: "+rs.getString(5));
					}
					break;
			    }
			    case 5:
			    {
			    	pst=connection.prepareStatement("select * from person where phone=? and password=?");
			    	System.out.println("Enter your registered phone Number");
					Long phone=scanner.nextLong();
					System.out.println("Enter your password");
					String password=scanner.next();
					pst.setLong(1, phone);
					pst.setString(2, password);
					rs=pst.executeQuery();
					if (rs.next())
					{
						System.out.println("Login Succesfull");
					}
					else
					{
						System.err.println("Invalid user and password");
					}
					break;
			    }
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
