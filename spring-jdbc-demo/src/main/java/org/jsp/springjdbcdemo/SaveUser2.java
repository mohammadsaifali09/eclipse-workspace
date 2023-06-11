package org.jsp.springjdbcdemo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class SaveUser2 {
	public static void main(String[] args) {
		String qry = "insert into user values(?,?,?,?)";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		int r= template.execute(qry,new MyPreparedStatementCallback());
	  /*int r = template.execute(qry, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setLong(3, phone);
				ps.setString(4, password);
				return ps.executeUpdate();
			}

		});*/
		System.out.println(r + " rows are affected");
	}
}

class MyPreparedStatementCallback implements PreparedStatementCallback<Integer> {

	public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		ps.setInt(1, 3);
		ps.setString(2, "XYZ");
		ps.setLong(3, 998899);
		ps.setString(4, "xyz123");
		return ps.executeUpdate();
	}

}
