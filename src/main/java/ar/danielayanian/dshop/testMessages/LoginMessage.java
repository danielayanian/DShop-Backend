package ar.danielayanian.dshop.testMessages;

import lombok.Data;

@Data
public class LoginMessage {
	
	private String message;
    private boolean status;
    
    public LoginMessage(String string, boolean b) {
		// TODO Auto-generated constructor stub
	}

}