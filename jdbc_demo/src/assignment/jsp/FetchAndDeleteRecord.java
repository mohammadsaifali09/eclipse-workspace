package assignment.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchAndDeleteRecord
{
	public static void main(String[] args)
	{
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
//		String qry="select * from user where id=?";
//		String qry="select * from user where name=?";
//		String qry="select * from user where phone=?";
		
//		String qry="delete from user where id=?";
//		String qry="delete from user where name=?";
//		String qry="delete from user where phone=?";
		
		String qry="select * from user where id=? and phone=?";
		
		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter the id to fetch and delete");
//		int id=scanner.nextInt();
//		String name=scanner.next();
//		Long phone=scanner.nextLong();
		
//		int id=scanner.nextInt();
//		String name=scanner.next();
//		Long phone=scanner.nextLong();
		
		System.out.println("Enter the id and phone to fetch");
		int id=scanner.nextInt();
		Long phone=scanner.nextLong();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Saif@@09");
			pst=connection.prepareStatement(qry);
//			pst.setInt(1, id);
//			pst.setString(1, name);
//			pst.setLong(1, phone);
			
//			pst.setInt(1, id);
//			pst.setString(1, name);
//			pst.setLong(1, phone);
//			pst.executeUpdate();
			
			pst.setInt(1, id);
			pst.setLong(2, phone);
		    rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString("name")+" "+rs.getLong(3));
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
