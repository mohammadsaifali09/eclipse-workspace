package org.jsp.springhibernatedemo.dao;

import org.jsp.springhibernatedemo.dto.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class UserDao extends HibernateDaoSupport {
	@Transactional
	public User saveUser(User user) {
		getHibernateTemplate().save(user);
		return user;
	}
	
	@Transactional
	public User updateUser(User user) {
		getHibernateTemplate().update(user);
		return user;
	}
	
	public User fetchUser(int id) {
		User user= getHibernateTemplate().get(User.class, id);
		return user;
	}
	
	@Transactional
	public boolean deleteUser(int id) {
		User user= fetchUser(id);
		if (user!=null) {
			getHibernateTemplate().delete(user);
			return true;
		}
		return false;
	}
}
