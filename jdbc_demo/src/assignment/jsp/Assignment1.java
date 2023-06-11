package assignment.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* Create a person table with the attributes id,name,age,phone,password */

public class Assignment1
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="Saif@@09";
//		Create Table
//		String query="create table person (id int not null,name varchar(45) null,age int null,phone bigint(20) null,password varchar(20),primary key(id))";

//		Insert Data
//		String insertquery="insert into person values(3,'Md',23,8809833242,'saif1234')";
		
//		Update data
//		String updatequery="update person set phone=9448382373,password='saif5678' where id=2";
		
//		Delete data
//		String deletequery="delete from person where id=3";
		
//		Fetch the data
		String fetchquery="select * from person where id=2";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			statement=connection.createStatement();
			System.out.println("Platform Created");
//			boolean res=statement.execute(query);
//			int res1=statement.executeUpdate(deletequery);
			rs=statement.executeQuery(fetchquery);
//			System.out.println(res1+" is the returned value and table is created");
			while (rs.next())
			{
				System.out.println(rs.getString("name"));
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
