package com.niit.ezone.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ezone.dao.CartDAO;
import com.niit.ezone.model.MyCart;

import javax.transaction.Transactional;

@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImpl  implements CartDAO
{
	
	@Autowired
	private SessionFactory  sessionFactory;
     public CartDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}
	public List<MyCart> getAllCartDetails(String uid) {
		
		return sessionFactory.getCurrentSession().createQuery("from MyCart where id='"+uid+"'").list();
	}
	public boolean save(MyCart myCart) {
		try {
			sessionFactory.getCurrentSession().save(myCart);
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(MyCart myCart) {
		try {
			sessionFactory.getCurrentSession().update(myCart);
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(MyCart myCart) {
		try {
			sessionFactory.getCurrentSession().delete(myCart);
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public MyCart getMyCartById(int cartid) {
		return (MyCart) sessionFactory.getCurrentSession().get(MyCart.class, cartid);

	
	}
	public MyCart getMyCartByName(String prodname) {
		return (MyCart) sessionFactory.getCurrentSession().createQuery("from MyCart where prodname='"+prodname+"'").uniqueResult();
	}
	public int getProductSum(int prodcost, int prodquan) {
		return prodcost*prodquan;
	}

	

}