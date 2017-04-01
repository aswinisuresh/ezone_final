package com.niit.ezone.dao;

import java.util.List;

import com.niit.ezone.model.User;

public interface UserDAO {
	
	public List<User> getAllUsers();
	
	public boolean saveUser(User user);
	
	public boolean deleteUser(User user);
	
	public boolean updateUser(User user);
	
	public User getUserById(String id);
	
	public User getUserByName(String name);

	public User validateLoginCredentials(String id,String password);
}
