package ar.danielayanian.dshop.services;

import java.util.List;
import java.util.Optional;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;

public interface UserService {
	
	public UserDTO userRegist(UserDTO userDTO);
	
	public Optional<UserDTO> findByEmail(String username);
	
	public void userUpdate(UserDTO userDTO);
	
	//public List<UserDTO> findAll();
	
    //public UserDTO addUser(UserDTO userDTO);

    //public LoginMessage loginUser(LoginDTO loginDTO);

}