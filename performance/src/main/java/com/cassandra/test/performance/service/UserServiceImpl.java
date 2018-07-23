package com.cassandra.test.performance.service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassandra.test.performance.repository.UserRepository;
import com.cassandra.test.performance.table.User;



@Service
public class UserServiceImpl implements UserService{

	private static final Logger log=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		int j=0;
		//System.out.println("inside create");
		long start=System.currentTimeMillis();
		//String var =  String.valueOf(start);
		//System.out.println(">>>>>>"+var);
		for( j=0; j<100000; j++)
		{
			user.setId(String.valueOf(new Random()));
			
			User users= userRepository.save(user);
		}
		long end=System.currentTimeMillis();
		long result=(end-start);
		String time =  String.valueOf(result);
		log.info("This is write of "+ j+ "record time   :"+time);
		return null;
		
	
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		 userRepository.findAll();
		long end=System.currentTimeMillis();
		long result=(end-start);
		String time =  String.valueOf(result);
		log.info("This is findall time   :"+time);
		return null;
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
		
		long start=System.currentTimeMillis();
		User user = (User) userRepository.findById(Id).get();
		long end=System.currentTimeMillis();
		long result=(end-start);
		String time =  String.valueOf(result);
		log.info("This is findById time   :"+time);
		return user;
	}

}
