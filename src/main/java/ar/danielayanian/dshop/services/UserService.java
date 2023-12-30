package ar.danielayanian.dshop.services;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.testMessages.LoginMessage;

public interface UserService {
	
    public String addUser(UserDTO userDTO);

    public LoginMessage loginUser(LoginDTO loginDTO);

}