package ar.danielayanian.dshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ar.danielayanian.dshop.services.InitService;

@SpringBootApplication
public class DshopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DshopApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(InitService initService) {
        return (args) -> {
        	
        	initService.loadInitial();
            	
        };
    }
}
