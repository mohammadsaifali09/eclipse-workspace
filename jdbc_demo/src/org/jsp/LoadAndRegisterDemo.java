package org.jsp;

import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

import java.sql.SQLException ;

public class LoadAndRegisterDemo
{
	public static void main(String[] args)
	{
		try
		{
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			System.out.println("Driver is Loaded and Registered Demo");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
