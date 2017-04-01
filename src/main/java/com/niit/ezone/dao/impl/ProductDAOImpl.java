package com.niit.ezone.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ezone.dao.ProductDAO;
import com.niit.ezone.model.Product;
@EnableTransactionManagement
@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Product> getAllProduct() {
		
			return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

		//@Transactional
	public boolean saveProduct(Product product) {
		try {
			Session session= sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			System.out.println("In save try");
			sessionFactory.getCurrentSession().save(product);
			System.out.println("In save try after sf");
			
			tx.commit();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
/*	@Transactional
	public boolean EditProduct(Product product) {
		try {
			Session session= sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			System.out.println("In save try");
			sessionFactory.getCurrentSession().Edit(product);
			System.out.println("In save try after sf");
			
			tx.commit();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}*/

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(int prodid) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(prodid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Product getProductByID(int prodid) {
	return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = '"+prodid + "'").uniqueResult();
		
	}

	public Product getProductByName(String prodname) {
		return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = '"+prodname + "'").list().get(0);
	}

	


	
	}


