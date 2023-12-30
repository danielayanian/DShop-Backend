package ar.danielayanian.dshop.controllers;

import ar.danielayanian.dshop.DTOs.LoginDTO;
import ar.danielayanian.dshop.DTOs.UserDTO;
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
    
    @GetMapping("/registro") //Eliminar
    public String saveUserEliminar(){
    	return "Holaaa";
    }
    
    @PostMapping("/registro")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        
    	System.out.println(userDTO.getNombre());
    	
    	//Aca esta el error, en el retorno
    	
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
    	//return new ResponseEntity.ok().header().body(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    	//return new ResponseEntity<UserDTO>(userDTO,responseHeaders, HttpStatus.OK);
    	
    	/*String id = userService.addUser(userDTO);
        return id;*/
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}