package com.niit.ezone.dao;

import java.util.List;

import com.niit.ezone.model.Supplier;

public interface SupplierDAO {
	
public List<Supplier> getAllSupplier();
	
	public boolean saveSupplier(Supplier supplier);
	
	public boolean updateSupplier(Supplier supplier);
	
	public boolean deleteSupplier(int suppid);
	
	public boolean deleteSupplier(Supplier supplier);
	
	public Supplier getSupplierByID(int suppid);
	
	public Supplier getSupplierByName(String suppname);

}
