package org.ba.chat.metier;

import java.util.List;
import java.util.Optional;

import org.ba.chat.dao.UserRepository;
import org.ba.chat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMetierImpl implements UserMetier {

	@Autowired
	UserRepository userRepository;
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUser(Integer id) {
		
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
