package ar.danielayanian.dshop.entities;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product extends BaseEntity {

	@Column(name="titulo", length = 100)
    private String titulo;
	
	@Column(name="titulo_normalizado", length = 100)
    private String tituloNormalizado;
	
	@Column(name="descripcion", length = 255)
    private String descripcion;
	
	@Column(name="fotoPrecargada", length = 50)
    private String fotoPrecargada;
	
	@Column(name="precio")
    private int precio;
	
	@Column(name="stock")
    private int stock;
	
	@Column(name="id_categoria")
    private Long idCategoria;
	
	@Column(name="destacado")
    private int destacado;
	
	@Column(name="oferta")
    private int oferta;
	
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
