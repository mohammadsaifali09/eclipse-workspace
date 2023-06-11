package org.jsp.springhibernatedemo.controller;

import org.jsp.springhibernatedemo.dao.UserDao;
import org.jsp.springhibernatedemo.dao.UserDao_POJO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteUser {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hib.xml");
		UserDao dao = context.getBean("dao", UserDao.class);
		UserDao_POJO daoPOJO = context.getBean("daoPOJO", UserDao_POJO.class);
		if (daoPOJO.deleteUser(4)) {
			System.out.println("Your details are deleted");
		} else {
			System.err.println("Invalid Id");
		}
	}
}
