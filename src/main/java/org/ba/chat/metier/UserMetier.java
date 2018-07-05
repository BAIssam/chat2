package org.ba.chat.metier;

import java.util.List;
import java.util.Optional;

import org.ba.chat.entities.User;

public interface UserMetier {
	
	User addUser(User user);
	Optional<User> getUser(Integer id);
	List<User> getAllUser();

}
