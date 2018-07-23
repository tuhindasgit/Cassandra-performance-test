package com.cassandra.test.performance.service;

import java.util.List;

import com.cassandra.test.performance.table.User;



public interface UserService {

	public User createUser(User user);
	
	public List<User> readAll();
	
	public User readOne(String Id);
	
	public List<User> delete(String Id);

	
}
