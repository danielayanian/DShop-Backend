package ar.danielayanian.dshop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private String dni;
    
    private String email;
    
    private String direccion;
    
    private String telefono;
    
    private String password;
    
    private String roles;
    
}