package org.jsp.springhibernatedemo.dao;

import org.jsp.springhibernatedemo.dto.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDao_POJO {
	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public User saveUser(User user) {
		template.save(user);
		return user;
	}

	@Transactional
	public User updateUser(User user) {
		template.update(user);
		return user;
	}

	public User fetchUser(int id) {
		User user = template.get(User.class, id);
		return user;
	}

	@Transactional
	public boolean deleteUser(int id) {
		User user = fetchUser(id);
		if (user != null) {
			template.delete(user);
			return true;
		}
		return false;
	}
}
