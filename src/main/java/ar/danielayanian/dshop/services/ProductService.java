package ar.danielayanian.dshop.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;

public interface ProductService {

	public Page<Product> findAll(Pageable pageable);
	
	public Page<Product> findDestacados(int destacado, int active, Pageable pageable);
	
	//public Page<Product> findDestacados(Pageable pageable);
	//public Page<Product> findDestacados(String destacado, String active, Pageable pageable);
	
	public Page<Product> findOfertas(int oferta, int active, Pageable pageable);
	
	public Page<Product> findAllCategoria(int idCategoria, int active, Pageable pageable);
	
	public Product findById(int id);
	
}
