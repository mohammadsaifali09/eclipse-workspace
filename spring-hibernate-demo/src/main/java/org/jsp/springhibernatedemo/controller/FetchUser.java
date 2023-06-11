package org.jsp.springhibernatedemo.controller;

import org.jsp.springhibernatedemo.dao.UserDao;
import org.jsp.springhibernatedemo.dao.UserDao_POJO;
import org.jsp.springhibernatedemo.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FetchUser {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hib.xml");
		UserDao dao = context.getBean("dao", UserDao.class);
		UserDao_POJO daoPOJO=context.getBean("daoPOJO",UserDao_POJO.class);
		User user = daoPOJO.fetchUser(4);
		if (user != null) {
			System.out.println("Id: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Phone: " + user.getPhone());
		} else {
			System.err.println("Invalid Id");
		}
	}
}
