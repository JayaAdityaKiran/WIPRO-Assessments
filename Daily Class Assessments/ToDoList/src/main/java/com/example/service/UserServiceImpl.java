package com.example.service;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.*;

@Service
public class UserServiceImpl {
	
	@Autowired 
	UserRepository usersRepository;
	
	

	public boolean findUser(com.example.model.User u) {
		// TODO Auto-generated method stub
		return usersRepository.findUser(u.getUsername(),u.getPassword());
	}
	
	
	
	
	
	
	 public String registerUser(User user) {
	        if (usersRepository.userExists(user.getUsername())) {
	            return "Username already exists!";
	        }
	        usersRepository.saveUser(user);
	        return "User registered successfully!";
	    }

}