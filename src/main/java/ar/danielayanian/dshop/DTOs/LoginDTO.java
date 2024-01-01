package ar.danielayanian.dshop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;

}