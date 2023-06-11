package org.jsp;

public class TestLoadAndRegister {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is Loaded and Registered");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Invalid Driver Class Name");
			e.printStackTrace();
		}

	}

}
