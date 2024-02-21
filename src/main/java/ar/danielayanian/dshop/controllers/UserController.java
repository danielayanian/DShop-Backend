package ar.danielayanian.dshop.controllers;

import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    
    @PostMapping("/registration")
    public ResponseEntity<Object> saveUSer(@RequestBody User user){
    	
    	Optional<User> userOpt = userService.findByEmail(user.getEmail());
    	
    	User userResponse = new User();
    	
    	if(userOpt.isPresent()) {
    		userResponse.setId((long)-33);//El mail ya estaba registrado
    		return ResponseEntity.ok(userResponse);
    	}
    	
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	
    	User result = userService.userRegist(user);
    	
    	result.setDni("");
    	result.setTelefono("");
        
        if (result.getId() > 0){
        	userResponse.setId(result.getId());
        	userResponse.setNombre(result.getNombre());
        	userResponse.setApellido(result.getApellido());
        	
            return ResponseEntity.ok(userResponse);//Usuario creado
        }
        userResponse.setId((long)-32);//Hubo un error y el usuario no ha sido registrado
		return ResponseEntity.ok(userResponse);
        
    }
    
    @PostMapping("/updateUser")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public String updateUser(@RequestBody User user){
    
    	userService.userUpdate(user);
        
		return "Actualizacion exitosa";
        
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
    public ResponseEntity<User> getUserDetails(){
    	
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