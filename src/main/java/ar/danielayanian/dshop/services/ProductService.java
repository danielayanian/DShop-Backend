package ar.danielayanian.dshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.danielayanian.dshop.entities.Product;

public interface ProductService {

	public Page<Product> findAll(Pageable pageable);
	
	public Page<Product> findAllByDestacadoAndActive(int destacado, int active, Pageable pageable);
	
	//public Page<Product> findDestacados(Pageable pageable);
	public Page<Product> findDestacados(String destacado, String active, Pageable pageable);
	
	public Page<Product> findOfertas(Pageable pageable);
	
	public Page<Product> findTelevisores(Pageable pageable);
	
	public Page<Product> findCelulares(Pageable pageable);
	
	public Page<Product> findNotebooks(Pageable pageable);
	
}
