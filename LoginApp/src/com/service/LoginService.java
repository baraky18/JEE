package com.service;

import java.util.HashMap;

import com.dto.User;

public class LoginService {

	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService(){
		users.put("johndoe", "John Doe");
		users.put("janedoe", "Jane Doe");
		users.put("bagsbunny", "Bags Bunny");
	}
	
	public boolean authenticate(String userId, String password){
		if(password == null || password.trim().isEmpty()){
			return false;
		}
		return true;
	}
	
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}
	
}
