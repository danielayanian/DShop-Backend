package ar.danielayanian.dshop.controllers;

import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/api/user/registration")
    public ResponseEntity<Object> saveUSer(@RequestBody UserDTO userDTO){
    	
    	Optional<UserDTO> userOpt = userService.findByEmail(userDTO.getEmail());
    	
    	UserDTO userDTOResponse = new UserDTO();
    	
    	if(userOpt.isPresent()) {
    		userDTOResponse.setId(-33);//El mail ya estaba registrado
    		return ResponseEntity.ok(userDTOResponse);
    	}
    	
    	userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    	UserDTO result = userService.userRegist(userDTO);
        
        if (result.getId() > 0){
        	userDTOResponse.setId(result.getId());
        	userDTOResponse.setNombre(result.getNombre());
        	userDTOResponse.setApellido(result.getApellido());
        	
            return ResponseEntity.ok(userDTOResponse);//Usuario creado
        }
        userDTOResponse.setId(-32);//Hubo un error y el usuario no ha sido registrado
		return ResponseEntity.ok(userDTOResponse);
        
    }
    
    @GetMapping("/")
    public String successfulLogin(){
    	
    	return "Login correcto";
        
    }
    
    /*@GetMapping("/api/user/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDTO>> getAllUSers(){
    	
        return ResponseEntity.ok(userService.findAll());
        
    }*/
    
    @GetMapping("/api/user/single")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<UserDTO> getUserDetails(){
    	
        return ResponseEntity.ok(userService.findByEmail(getLoggedInUserDetails().getUsername()).get());
    
    }

    public UserDetails getLoggedInUserDetails(){
    	
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
        
    }
    
}