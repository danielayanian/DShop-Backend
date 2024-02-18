package ar.danielayanian.dshop.services;

import java.util.Optional;
import ar.danielayanian.dshop.entities.User;

public interface UserService {
	
	public User userRegist(User user);
	
	public Optional<User> findByEmail(String username);
	
	public void userUpdate(User user);

}