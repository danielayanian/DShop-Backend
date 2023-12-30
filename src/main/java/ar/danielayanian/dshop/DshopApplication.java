package ar.danielayanian.dshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//Sacar el exclude cuando termine lo de spring security

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DshopApplication.class, args);
	}

}
