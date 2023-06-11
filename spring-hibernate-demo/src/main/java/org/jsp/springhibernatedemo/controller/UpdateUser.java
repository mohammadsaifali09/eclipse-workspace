package org.jsp.springhibernatedemo.controller;

import org.jsp.springhibernatedemo.dao.UserDao;
import org.jsp.springhibernatedemo.dao.UserDao_POJO;
import org.jsp.springhibernatedemo.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateUser {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hib.xml");
		UserDao dao=context.getBean("dao",UserDao.class);
		UserDao_POJO daoPOJO=context.getBean("daoPOJO",UserDao_POJO.class);
		User user = new User();
		user.setId(4);
		user.setName("Saif Ali");
		user.setPhone(9448382373L);
		user.setPassword("ali123");
		daoPOJO.updateUser(user);
	}
}
