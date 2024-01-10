package ar.danielayanian.dshop;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.repositories.UserRepository;
import ar.danielayanian.dshop.services.UserService;

@SpringBootApplication
public class DshopApplication {

	@Autowired
	UserService userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DshopApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
        	
        	Optional<UserDTO> userDTOOpt = userService.findByEmail("dani@gmail.com");
        	
        	if(!userDTOOpt.isPresent()) {
        		UserDTO userDTO = new UserDTO();
        		userDTO.setNombre("Daniel");
        		userDTO.setApellido("Ayanian");
        		userDTO.setEmail("dani@gmail.com");
        		userDTO.setPassword(passwordEncoder.encode("root"));
            	userDTO.setRoles("ADMIN");
            	
            	userService.userRegist(userDTO);
           
        	}
        	
        };
    }
	
}
