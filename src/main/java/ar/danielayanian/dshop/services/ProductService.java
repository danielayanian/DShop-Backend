package ar.danielayanian.dshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ar.danielayanian.dshop.entities.Product;

public interface ProductService {

	public Page<Product> findAll(Pageable pageable);
	
	public Page<Product> findDestacados(int destacado, int active, Pageable pageable);
	
	//public Page<Product> findDestacados(Pageable pageable);
	//public Page<Product> findDestacados(String destacado, String active, Pageable pageable);
	
	public Page<Product> findOfertas(int oferta, int active, Pageable pageable);
	
	public Page<Product> findAllCategoria(Long idCategoria, int active, Pageable pageable);
	
	public Product findById(Long id);
	
	public void insert(Product product);
	
	//public Page<Product> findAllPorPrecioMaximo(Long precio, int active, String tipo, Pageable pageable);
	
	public Page<Product> findAllDestPorPrecio(Long precio, int active, Pageable pageable);
	
}
