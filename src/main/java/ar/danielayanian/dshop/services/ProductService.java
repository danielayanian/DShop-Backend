package ar.danielayanian.dshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.danielayanian.dshop.entities.Product;

public interface ProductService {

	public Page<Product> findAll(Pageable pageable);
	
	public Page<Product> findDestacados(Pageable pageable);
	
	public Page<Product> findOfertas(Pageable pageable);
	
	public Page<Product> findTelevisores(Pageable pageable);
	
	public Page<Product> findCelulares(Pageable pageable);
	
	public Page<Product> findNotebooks(Pageable pageable);
	
}
