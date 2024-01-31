package ar.danielayanian.dshop.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="purchase")
public class Purchase extends BaseEntity {
	
	//Indicar clave foranea
	@Column(name="idUser")
    private Long idUser;
	
	//Indicar clave foranea
	/*@Column(name="idProduct")
    private int idProduct;*/
	
	//Poner anotaciones de one to many, y en entity Product tambien
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", nullable = false)
	private Product product;
	
	@Column(name="date")
    private Date date;
	
	@Column(name="cantidad")
    private int cantidad;
	
	@Column(name="precioUnidad")
    private int precioUnidad;
	
	@Column(name="active")
    private int active;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity that)) return false;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
	
}
