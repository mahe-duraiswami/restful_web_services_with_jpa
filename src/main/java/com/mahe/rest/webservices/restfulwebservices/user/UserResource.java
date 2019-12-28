package com.mahe.rest.webservices.restfulwebservices.user;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.fetchAllUsers();
	}
	
	@GetMapping(path = "/users/{userId}") 
	public User retrieveUser(@PathVariable int userId) {
		User user = service.fetchUser(userId);
		if (user==null)
			throw new UserNotFoundException("User ID - "+userId);
		
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = service.addUser(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{userId}")
			.buildAndExpand(newUser.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{userId}") 
	public void deleteUser(@PathVariable int userId) {

		User user = service.deleteUserByID(userId);

		if (user==null)
			throw new UserNotFoundException("User ID - "+userId);

	}

}
