package com.cassandra.test.performance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassandra.test.performance.repository.UserRepository;
import com.cassandra.test.performance.table.User;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		User users= userRepository.save(user);
		return users;
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	

	@Override
	public List<User> delete(String Id) {
		// TODO Auto-generated method stub
		User entity = (User) userRepository.findById(Id).get();
    	userRepository.deleteById(entity.getId());
    	//userRepository.deleteById(Id);
    	
		return userRepository.findAll();
	}

	@Override
	public User readOne(String Id) {
		User user = (User) userRepository.findById(Id).get();
		
		return user;
	}

}
