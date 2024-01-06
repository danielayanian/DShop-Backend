package ar.danielayanian.dshop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
    private int id;
    
    private String nombre;
    
    private String apellido;
    
    private String email;
    
    private String password;
    
    private String roles;
    
}