package ar.danielayanian.dshop.testMessages;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginMessage {
	
	private String message;
	private LoginDTO loginDTO;
    private boolean status;
    
}