package org.ba.chat.controller;

import java.util.List;
import java.util.Optional;

import org.ba.chat.entities.User;
import org.ba.chat.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	public UserMetier userMetier;
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User addUser(@RequestBody User user){
		return userMetier.addUser(user);
	}
	
	@RequestMapping(value="/user/{num}", method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable Integer num){
		return userMetier.getUser(num);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getAllUser(){
		return userMetier.getAllUser();
	}

}
