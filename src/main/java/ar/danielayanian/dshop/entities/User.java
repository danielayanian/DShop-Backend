package ar.danielayanian.dshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
    
    @Column(name="nombre", length = 255)
    private String nombre;
    
    @Column(name="apellido", length = 255)
    private String apellido;
    
    @Column(name="email", length = 255, unique = true)
    private String email;
    
    @Column(name="password", length = 255)
    private String password;
    
    @Column(name="roles", length = 255)
    private String roles;
    
}