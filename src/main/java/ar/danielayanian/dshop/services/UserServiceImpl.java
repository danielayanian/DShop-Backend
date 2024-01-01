package ar.danielayanian.dshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.repositories.UserRepository;
import ar.danielayanian.dshop.testMessages.LoginMessage;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
 
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }

    }

}