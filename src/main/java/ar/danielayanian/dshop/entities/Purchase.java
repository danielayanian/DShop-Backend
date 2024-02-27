package ar.danielayanian.dshop.entities;

import java.util.Objects;

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
	
	@Column(name="id_user")
    private Long idUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
	private Product product;
	
	@Column(name="fecha", length = 50)
    private String fecha;
	
	@Column(name="cantidad")
    private int cantidad;
	
	@Column(name="precio_unidad")
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
