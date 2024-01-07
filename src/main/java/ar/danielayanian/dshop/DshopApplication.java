package ar.danielayanian.dshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.repositories.UserRepository;

@SpringBootApplication
public class DshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DshopApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
        	User user = new User();
        	user.setNombre("Daniel");
        	user.setApellido("Ayanian");
        	user.setEmail("dani@gmail.com");
        	user.setPassword("root");
        	user.setRoles("ADMIN");
        	userRepository.save(user);
        };
    }
	
}
