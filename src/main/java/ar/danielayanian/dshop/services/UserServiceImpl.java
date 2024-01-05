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
    public User userRegist(User user) {
    	
    	return userRepository.save(user);
    	
    }
    
    @Override
    public Optional<User> findByEmail(String username){
    	
    	return userRepository.findByEmail(username);
    	
    }
    
    @Override
    public List<User> findAll(){
    	
    	return userRepository.findAll();
    	
    }
    
    /*
    @Override
    public UserDTO addUser(UserDTO userDTO) {

    	User user = new User();
    	user.setNombre(userDTO.getNombre());
    	user.setApellido(userDTO.getApellido());
    	user.setEmail(userDTO.getEmail());
    	user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));

        user = userRepository.save(user);
        
        UserDTO userDTOdeRetorno = new UserDTO(user.getId(), user.getNombre(),
        		user.getApellido(), "", "");

        return userDTOdeRetorno;
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
 
    	LoginMessage loginMessage;
    	
    	System.out.println(loginDTO.getEmail());
    	
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        
        
        
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                
                if (user.isPresent()) {
                	LoginDTO loginDTOdeRetorno = new LoginDTO(user1.getId(), user1.getNombre(),
                			user1.getApellido(), user1.getEmail(), "");
                	loginMessage = new LoginMessage("Login exitoso", loginDTOdeRetorno, true);
                } else {
                	loginMessage = new LoginMessage("Login fallido, intente nuevamente", null, false);
                }
            } else {
            	loginMessage = new LoginMessage("La contraseña es incorrecta", null, false);
            }
        }else {
        	loginMessage = new LoginMessage("No existe el email", null, false);
        }
        
        return loginMessage;

    }
    */

}