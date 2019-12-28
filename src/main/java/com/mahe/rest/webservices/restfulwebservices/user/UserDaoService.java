package com.mahe.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static Integer usersCount = 3;
	
	static {
		users.add(new User(1,"Mahe", new Date()));
		users.add(new User(2,"Ken", new Date()));
		users.add(new User(3,"John",new Date()));
		
	}
	
	public List<User> fetchAllUsers() {
		return users;
	}
	
	public User fetchUser(int userId) {
		for(User user:users) {
			if(user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}
	
	public User addUser(User user) {
		if (user.getUserId() == null) {
			user.setUserId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User deleteUserByID(int userId) {
		
		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getUserId() == userId) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	

}
