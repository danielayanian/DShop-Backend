package ar.danielayanian.dshop.services;

import java.util.List;
import java.util.Optional;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;

public interface UserService {
	
	public User userRegist(User user);
	
	public Optional<User> findByEmail(String username);
	
	public List<User> findAll();
	
    //public UserDTO addUser(UserDTO userDTO);

    //public LoginMessage loginUser(LoginDTO loginDTO);

}