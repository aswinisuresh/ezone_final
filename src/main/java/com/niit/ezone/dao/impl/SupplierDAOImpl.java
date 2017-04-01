package com.niit.ezone.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ezone.dao.SupplierDAO;
import com.niit.ezone.model.Category;
import com.niit.ezone.model.Supplier;
@Transactional
@Repository
public class SupplierDAOImpl  implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Supplier> getAllSupplier() {
		return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean saveSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); 
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean deleteSupplier(int suppid) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierByID(suppid));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Supplier getSupplierByID(int suppid) {
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, suppid);
	}

	public Supplier getSupplierByName(String suppname) {
		return(Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where name ='"+suppname+"'").uniqueResult();
	}
	
}
