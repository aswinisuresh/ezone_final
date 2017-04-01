package com.niit.ezone.dao;

import java.util.List;

import com.niit.ezone.model.Category;

public interface CategoryDAO {
	
	public List<Category> getAllCategory();
	
	public boolean saveCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(int catid);
	
	public boolean deleteCategory(Category category);
	
	public Category getCategoryByID(int catid);
	
	public Category getCategoryByName(String catname);

	
}
