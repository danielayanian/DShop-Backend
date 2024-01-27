package ar.danielayanian.dshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.danielayanian.dshop.entities.Category;
import ar.danielayanian.dshop.entities.Product;
import ar.danielayanian.dshop.repositories.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(int destacado, int active, Pageable pageable) {
		return productRepository.findAllByDestacadoAndActive(destacado, active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	/*@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(Pageable pageable) {
		return productRepository.findDestacados(pageable);
	}*/
	/*@Override
	@Transactional(readOnly = true)
	public Page<Product> findDestacados(String destacado, String active, Pageable pageable) {
		return productRepository.findDestacados(destacado, active, pageable);
	}*/
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findOfertas(int oferta, int active, Pageable pageable) {
		return productRepository.findAllByOfertaAndActive(oferta, active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllCategoria(int idCategoria, int active, Pageable pageable) {
		return productRepository.findAllByIdCategoriaAndActive(idCategoria, active, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Product findById(int id) {
		Optional<Product> op = productRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
}