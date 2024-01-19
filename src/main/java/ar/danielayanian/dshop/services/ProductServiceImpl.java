package ar.danielayanian.dshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.repositories.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(Pageable pageable) {
		return productRepository.findDestacados(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findOfertas(Pageable pageable) {
		return productRepository.findOfertas(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findTelevisores(Pageable pageable) {
		return productRepository.findTelevisores(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findCelulares(Pageable pageable) {
		return productRepository.findCelulares(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findNotebooks(Pageable pageable) {
		return productRepository.findNotebooks(pageable);
	}
	
}
