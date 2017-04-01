package com.niit.ezone.dao;
import java.util.List;

import com.niit.ezone.model.Product;

public interface ProductDAO {

	public List<Product> getAllProduct();
	
	public boolean saveProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct (int prodid);
	
	public boolean deleteProduct (Product product);
	
	public Product getProductByID(int prodid);
	
	public Product getProductByName(String prodname);
	
}
