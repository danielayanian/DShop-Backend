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
@Table(name="user")
public class User extends BaseEntity {
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="dni")
    private String dni;
    
    @Column(name="email")
    private String email;
    
    @Column(name="direccion")
    private String direccion;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="password", length = 255)
    private String password;
    
    @Column(name="roles", length = 255)
    private String roles;
    
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