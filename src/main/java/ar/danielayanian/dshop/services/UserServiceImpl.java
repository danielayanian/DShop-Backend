package ar.danielayanian.dshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO userRegist(UserDTO userDTO) {
    	
    	User user = new User();
    	user.setNombre(userDTO.getNombre());
    	user.setApellido(userDTO.getApellido());
    	user.setEmail(userDTO.getEmail());
    	user.setPassword(userDTO.getPassword());
    	user.setRoles(userDTO.getRoles());
    	
    	User userCreated = userRepository.save(user);
    	
    	userDTO.setId(userCreated.getId());
    	userDTO.setEmail("");
    	userDTO.setPassword("");
    	userDTO.setRoles("");
    	
    	return userDTO;
    	
    }
    
    @Override
    public Optional<UserDTO> findByEmail(String username){
    	
    	UserDTO userDTO = new UserDTO();
    	
    	Optional<User> userOpt = userRepository.findByEmail(username);
    	if(userOpt.isPresent()) {
        	userDTO.setId(userOpt.get().getId());
        	userDTO.setNombre(userOpt.get().getNombre());
        	userDTO.setApellido(userOpt.get().getApellido());
        	
        	Optional<UserDTO> userDTOOpt = Optional.ofNullable(userDTO);
        	return userDTOOpt;
    	}
    	
    	Optional<UserDTO> userDTOOpt = Optional.ofNullable(null);
    	
    	return userDTOOpt;
    	
    }
    
    /*@Override
    public List<UserDTO> findAll(){
    	
    	//Que devuelva una lista de usuarios DTO
    	
    	return userRepository.findAll();
    	
    }*/
    
}