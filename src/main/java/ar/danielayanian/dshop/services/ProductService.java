package ar.danielayanian.dshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.danielayanian.dshop.entities.Product;

public interface ProductService {

	public Page<Product> findAll(Pageable pageable);
	
}
