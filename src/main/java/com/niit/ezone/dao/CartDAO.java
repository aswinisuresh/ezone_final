package com.niit.ezone.dao;

import java.util.List;
import com.niit.ezone.model.MyCart;

public interface CartDAO {
	
public List<MyCart> getAllCartDetails(String uid);//

	public boolean save(MyCart myCart);
	
	public boolean update(MyCart myCart);
	
	public boolean delete(MyCart myCart);
	
	public MyCart getMyCartById(int cartid);
	
	public MyCart getMyCartByName(String prodname);
	
	public int getProductSum(int prodcost ,int prodquan);
	
	}
