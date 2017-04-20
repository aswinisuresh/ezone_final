package com.niit.ezone.dao;

import java.util.List;

import com.niit.ezone.model.Checkout;
import com.niit.ezone.model.MyCart;

public interface CheckoutDAO {
public List<Checkout> getlist(String id);
	
	public boolean Save(Checkout checkout);
	
	public boolean update(Checkout checkout);
	
	public boolean delete(Checkout checkout);
	
	public String checktableforempty(String id);
	
	public List<MyCart> getallcartdetails(String cartid);
	
	public Boolean execute(String id);
}
