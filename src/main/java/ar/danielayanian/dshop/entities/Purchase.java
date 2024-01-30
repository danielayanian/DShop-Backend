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
@Table(name="purchase")
public class Purchase {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	//Indicar clave foranea
	@Column(name="idUser")
    private int idUser;
	
	//Indicar clave foranea
	@Column(name="idProduct")
    private int idProduct;
	
	@Column(name="cantidad")
    private int cantidad;
	
	@Column(name="precioUnidad")
    private int precioUnidad;
	
	@Column(name="active")
    private int active;
	
}
