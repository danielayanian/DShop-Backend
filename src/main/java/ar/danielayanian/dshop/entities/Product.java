package ar.danielayanian.dshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

	@Column(name="titulo", length = 255)
    private String titulo;
	
	@Column(name="descripcion", length = 255)
    private String descripcion;
	
	@Column(name="precio")
    private int precio;
	
	@Column(name="stock")
    private int stock;
	
	//Indicar clave foranea
	@Column(name="idCategoria")
    private int idCategoria;
	
	@Column(name="destacado")
    private int destacado;
	
	@Column(name="oferta")
    private int oferta;
	
	@Column(name="active")
    private int active;
	
	//@Column(name="category")
    //private Category category;
	
}
