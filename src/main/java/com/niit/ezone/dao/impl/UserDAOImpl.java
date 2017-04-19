package com.niit.ezone.dao.impl;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ezone.dao.UserDAO;
import com.niit.ezone.model.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	User user;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public boolean saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User getUserByName(String name) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where name='"+name+"'").uniqueResult();
	}

	public User validateLoginCredentials(String id, String password) {
		user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}
	
}
