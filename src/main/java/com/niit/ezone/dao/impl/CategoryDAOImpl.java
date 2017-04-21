package com.niit.ezone.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ezone.dao.CategoryDAO;
import com.niit.ezone.model.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}
	@Transactional
	public boolean saveCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); 
			return false;
		}
		
	}
	@Transactional
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}
	@Transactional
	public boolean deleteCategory(int catid) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(catid));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}
	@Transactional
	public Category getCategoryByID(int catid) {
		return (Category)	sessionFactory.getCurrentSession().get(Category.class, catid);
	}
	@Transactional
	public Category getCategoryByName(String catname) {
		return	 (Category)sessionFactory.getCurrentSession().createQuery("from Category where name ='"+catname+"'").uniqueResult();
	}


}
