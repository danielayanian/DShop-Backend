package ar.danielayanian.dshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {

	@Id
    @Column(name="id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="nombre", length = 255)
    private String nombre;
    
    @Column(name="email", length = 255)
    private String email;
    
    @Column(name="password", length = 255)
    private String password;
    
    @Column(name="repitaPassword", length = 255)
    private String repitaPassword;
    
    public User(String nombre, String email, String password, String repitaPassword) {
		// TODO Auto-generated constructor stub
	}
    
}