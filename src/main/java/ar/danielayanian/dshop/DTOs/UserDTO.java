package ar.danielayanian.dshop.DTOs;

import lombok.Data;

@Data
public class UserDTO {
	
    //private int id;
    
    private String nombre;
    
    private String email;
    
    private String password;
    
    private String repitaPassword;
    
}