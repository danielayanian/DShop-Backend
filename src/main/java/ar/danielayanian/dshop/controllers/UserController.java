package ar.danielayanian.dshop.controllers;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
import ar.danielayanian.dshop.entities.User;
import ar.danielayanian.dshop.services.UserService;
import ar.danielayanian.dshop.testMessages.LoginMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @PostMapping("/registro")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
    	
        UserDTO userDTOdeRetorno = userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(userDTOdeRetorno);
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
    	
    	LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
        
    }
    
}