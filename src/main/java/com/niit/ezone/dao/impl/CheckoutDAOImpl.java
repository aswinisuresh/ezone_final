package com.niit.ezone.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ezone.model.Checkout;
import com.niit.ezone.model.MyCart;
@Repository("CheckoutDAO")
@EnableTransactionManagement
public class CheckoutDAOImpl {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Transactional
	public List<Checkout> getlist(String id) 
	{
		return sessionfactory.getCurrentSession().createQuery("from Checkout where id='"+id+"'").list();
		
	}

	@Transactional
	public boolean Save(Checkout checkout) 
	{
			
		try {
			sessionfactory.getCurrentSession().save(checkout);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
		}

	@Transactional
	public boolean update(Checkout checkout) {
		try {
			sessionfactory.getCurrentSession().update(checkout);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
		}

	@Transactional
	public boolean delete(Checkout checkout) 
	{
		try {
			sessionfactory.getCurrentSession().delete(checkout);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
	}

	@Transactional
	public Boolean execute(String id)
	{
		try {
		 sessionfactory.getCurrentSession().createSQLQuery("update mycart set status='O' where id='"+id+"'").executeUpdate();
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public String checktableforempty(String id)	
	{
		return sessionfactory.getCurrentSession().createSQLQuery("select count(*) from checkout where id='"+id+"'").uniqueResult().toString();
	}

	@Transactional
	public List<MyCart> getallcartdetails(String cartid)
	{
			return sessionfactory.getCurrentSession().createQuery("from MyCart where cartid='"+cartid+"'").list();
			
	
	}
	
	@Transactional
	public double gettotal(String uid)
	{
		String result=sessionfactory.getCurrentSession().createSQLQuery("select isnull(sum(cartsum),0) from mycart where user_id='"+uid+"' and status='O'").uniqueResult().toString();
		double total=Double.parseDouble(result);
		return total;
	}
}
