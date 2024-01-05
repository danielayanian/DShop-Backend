package ar.danielayanian.dshop.controllers;

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
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
    
    /*@PostMapping("/registro")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
    	
        UserDTO userDTOdeRetorno = userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(userDTOdeRetorno);
        
    }*/
    
    @PostMapping("/user/registration")
    public ResponseEntity<Object> saveUSer(@RequestBody User user){
    	
    	Optional<User> existeUsuario = userService.findByEmail(user.getEmail());
    	
    	if(existeUsuario.isPresent()) {
    		user.setId(-33);//El mail ya estaba registrado
    		return ResponseEntity.ok(user);
    	}
    	
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = userService.userRegist(user);
        
        if (result.getId() > 0){
        	User userToResponse = new User();
        	userToResponse.setId(result.getId());
        	userToResponse.setNombre(result.getNombre());
        	userToResponse.setApellido(result.getApellido());
        	
            return ResponseEntity.ok(userToResponse);//Usuario creado
        }
        user.setId(-32);//Hubo un error y el usuario no ha sido registrado
		return ResponseEntity.ok(user);
        
    }
    
    @GetMapping("/todo")
    public String todos() {

        return "Estoy logueado de antes";

    }
    
    @PostMapping("/")
    public String successfulLogin(){
    	
    	return "Thisn is publickly accesible withing needing authentication ";
        
    }
    
    @GetMapping("/user/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<User>> getAllUSers(){
    	
        return ResponseEntity.ok(userService.findAll());
        
    }
    
    @GetMapping("/user/single")
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